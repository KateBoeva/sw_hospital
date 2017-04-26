package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.sw.hospital.dao.models.*;
import ru.itis.sw.hospital.dao.models.dto.LoginInfoDto;
import ru.itis.sw.hospital.dao.utils.ParamsMapper;
import ru.itis.sw.hospital.dao.utils.SqlQueryExecutor;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Repository
public class HealthDaoImpl implements HealthDao {

    @Autowired
    DaoArgumentsVerifier mDaoArgumentsVerifier;
    @Autowired
    private SqlQueryExecutor mSqlQueryExecutor;
    @Autowired
    private ParamsMapper mParamsMapper;

    static final RowMapper<City> CITY_ROW_MAPPER = (resultSet, i) -> {
        try {
            return new City(resultSet.getInt("id"), resultSet.getString("name"));
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    static final RowMapper<Hospital> HOSPITAL_ROW_MAPPER = (resultSet, i) -> {
        try {
            return new Hospital(resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getString("address"), resultSet.getInt("id_city"));
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    static final RowMapper<Doctor> DOCTOR_ROW_MAPPER = (resultSet, i) -> {
        try {
            return new Doctor(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("surname"),
                    resultSet.getInt("id_city"), resultSet.getInt("id_hospital"), resultSet.getString("specialization"),
                    resultSet.getString("experience"), resultSet.getString("regalies"), resultSet.getString("phone"),
                    resultSet.getString("patronymic"));
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    static final RowMapper<Timetable> TIMETABLE_ROW_MAPPER = (resultSet, i) -> {
        try {
            return new Timetable(resultSet.getInt("id"), resultSet.getInt("id_doctor"),
                    resultSet.getString("monday"), resultSet.getString("tuesday"), resultSet.getString("wednesday"),
                    resultSet.getString("thursday"), resultSet.getString("friday"), resultSet.getString("saturday"),
                    resultSet.getString("sunday"));
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    @Override
    public TokenObject auth(LoginInfoDto loginInfoDto) {
        try {
            mDaoArgumentsVerifier.verifyLogin(loginInfoDto.getLogin(), loginInfoDto.getPassword());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Login/password incorrect");
        }
        //берём token
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("login", "password"),
                asList(loginInfoDto.getLogin(), loginInfoDto.getPassword()));
        int status = mSqlQueryExecutor.queryForInt(Constants.SQL_GET_STATUS_BY_LOGIN_PASSWORD, paramMap);
        return new TokenObject(status==1?"6c7ca345f63f835cb353ff15bd6c5e052ec08e7a":"9c031d62a3c4909b216e1d86b7f69b982bdca0f9", status);
    }

    @Override
    public List<City> getCitites() {
        return mSqlQueryExecutor.queryForObjects(Constants.SQL_GET_CITIES, CITY_ROW_MAPPER);
    }

    @Override
    public List<Hospital> getHospitals(int cityId) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id_city"), asList(cityId));
        return mSqlQueryExecutor.queryForObjects(Constants.SQL_GET_HOSPITALS_BY_CITY_ID, paramMap, HOSPITAL_ROW_MAPPER);
    }

    @Override
    public List<Doctor> getDoctors(int hospitalId) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id_hospital"), asList(hospitalId));
        return mSqlQueryExecutor.queryForObjects(Constants.SQL_GET_DOCTORS_BY_HOSPITAL_ID, paramMap, DOCTOR_ROW_MAPPER);
    }

    @Override
    public Timetable getTimetable(int doctorId) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id_doctor"), asList(doctorId));
        return mSqlQueryExecutor.queryForObject(Constants.SQL_GET_TIMETABLE_BY_DOCTOR_ID, paramMap, TIMETABLE_ROW_MAPPER);
    }
}

package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.sw.hospital.dao.models.City;
import ru.itis.sw.hospital.dao.models.Doctor;
import ru.itis.sw.hospital.dao.models.Hospital;
import ru.itis.sw.hospital.dao.models.Timetable;
import ru.itis.sw.hospital.dao.utils.ParamsMapper;
import ru.itis.sw.hospital.dao.utils.SqlQueryExecutor;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Repository
public class HealthDaoImpl implements HealthDao {

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

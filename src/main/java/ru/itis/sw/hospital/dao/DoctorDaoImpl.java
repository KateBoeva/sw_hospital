package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.sw.hospital.models.Doctor;
import ru.itis.sw.hospital.utils.Constants;
import ru.itis.sw.hospital.utils.ParamsMapper;
import ru.itis.sw.hospital.utils.SqlQueryExecutor;
import ru.itis.sw.hospital.repository.DoctorDao;
import ru.itis.sw.hospital.repository.TimetableDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Repository
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private TimetableDao mTimetableDao;

    @Autowired
    private SqlQueryExecutor mSqlQueryExecutor;

    @Autowired
    private ParamsMapper mParamsMapper;

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

    @Override
    public List<Doctor> getDoctors(int hospitalId) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id_hospital"), asList(hospitalId));
        return mSqlQueryExecutor.queryForObjects(Constants.SQL_GET_DOCTORS_BY_HOSPITAL_ID, paramMap, DOCTOR_ROW_MAPPER);
    }

    @Override
    public Doctor getDoctor(int id) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id"), asList(id));
        return mSqlQueryExecutor.queryForObject(Constants.SQL_GET_DOCTOR_BY_ID, paramMap, DOCTOR_ROW_MAPPER);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("name", "surname", "id_city", "id_hospital", "specialization", "experience", "regalies", "phone", "patronymic"),
                asList(doctor.getName(), doctor.getSurname(), doctor.getCityId(), doctor.getHospitalId(), doctor.getSpecialization(), doctor.getExperience(), doctor.getRegalies(), doctor.getPhone(), doctor.getPatronymic()));
        mSqlQueryExecutor.updateQuery(Constants.SQL_ADD_DOCTOR, paramMap);
        int doctorId = mSqlQueryExecutor.queryForInt(Constants.SQL_GET_ID_BY_DOCTOR, paramMap);
        mTimetableDao.addTimetable(doctorId);
    }

    @Override
    public void deleteDoctor(int id) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id"), asList(id));
        mSqlQueryExecutor.updateQuery(Constants.SQL_DELETE_DOCTOR, paramMap);
    }
}

package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.sw.hospital.dao.models.Timetable;
import ru.itis.sw.hospital.dao.utils.ParamsMapper;
import ru.itis.sw.hospital.dao.utils.SqlQueryExecutor;
import ru.itis.sw.hospital.dao.repository.TimetableDao;

import java.sql.SQLException;
import java.util.Map;

import static java.util.Arrays.asList;

@Repository
public class TimetableDaoImpl implements TimetableDao {

    @Autowired
    private SqlQueryExecutor mSqlQueryExecutor;

    @Autowired
    private ParamsMapper mParamsMapper;

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
    public Timetable getTimetable(int doctorId) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id_doctor"), asList(doctorId));
        return mSqlQueryExecutor.queryForObject(Constants.SQL_GET_TIMETABLE_BY_DOCTOR_ID, paramMap, TIMETABLE_ROW_MAPPER);
    }

    @Override
    public void addTimetable(int doctorId) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id_doctor"), asList(doctorId));
        mSqlQueryExecutor.updateQuery(Constants.SQL_ADD_TIMETABLE, paramMap);
    }

    @Override
    public void changeTimetable(Timetable timetable) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id_doctor", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"),
                asList(timetable.getDoctorId(), timetable.getMonday(), timetable.getTuesday(), timetable.getWednesday(), timetable.getThursday(), timetable.getFriday(), timetable.getSaturday(), timetable.getSunday()));
        mSqlQueryExecutor.updateQuery(Constants.SQL_UPDATE_TIMETABLE, paramMap);
    }
}

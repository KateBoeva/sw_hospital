package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.sw.hospital.dao.models.Hospital;
import ru.itis.sw.hospital.dao.utils.ParamsMapper;
import ru.itis.sw.hospital.dao.utils.SqlQueryExecutor;
import ru.itis.sw.hospital.dao.repository.HospitalDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Repository
public class HospitalDaoImpl implements HospitalDao {

    @Autowired
    private SqlQueryExecutor mSqlQueryExecutor;

    @Autowired
    private ParamsMapper mParamsMapper;

    static final RowMapper<Hospital> HOSPITAL_ROW_MAPPER = (resultSet, i) -> {
        try {
            return new Hospital(resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getString("address"), resultSet.getInt("id_city"));
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    @Override
    public List<Hospital> getHospitals(int cityId) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id_city"), asList(cityId));
        return mSqlQueryExecutor.queryForObjects(Constants.SQL_GET_HOSPITALS_BY_CITY_ID, paramMap, HOSPITAL_ROW_MAPPER);
    }

    @Override
    public void addHospital(Hospital hospital) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("name", "address", "id_city"),
                asList(hospital.getName(), hospital.getAddress(), hospital.getCityId()));
        mSqlQueryExecutor.updateQuery(Constants.SQL_ADD_HOSPITAL, paramMap);
    }
}

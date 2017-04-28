package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.sw.hospital.models.*;
import ru.itis.sw.hospital.utils.Constants;
import ru.itis.sw.hospital.utils.ParamsMapper;
import ru.itis.sw.hospital.utils.SqlQueryExecutor;
import ru.itis.sw.hospital.repository.CityDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Repository
public class CityDaoImpl implements CityDao {

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

    @Override
    public List<City> getCities() {
        return mSqlQueryExecutor.queryForObjects(Constants.SQL_GET_CITIES, CITY_ROW_MAPPER);
    }

    @Override
    public City getCity(int id) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id"), asList(id));
        return mSqlQueryExecutor.queryForObject(Constants.SQL_GET_CITY_BY_ID, paramMap, CITY_ROW_MAPPER);
    }

    @Override
    public void addCity(City city) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("name"), asList(city.getName()));
        mSqlQueryExecutor.updateQuery(Constants.SQL_ADD_CITY, paramMap);
    }

    @Override
    public void deleteCity(int id) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("id"), asList(id));
        mSqlQueryExecutor.updateQuery(Constants.SQL_DELETE_CITY, paramMap);
    }
}

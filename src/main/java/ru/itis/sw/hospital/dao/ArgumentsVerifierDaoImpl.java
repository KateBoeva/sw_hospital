package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.repository.ArgumentsVerifierDao;
import ru.itis.sw.hospital.utils.Constants;
import ru.itis.sw.hospital.utils.ParamsMapper;
import ru.itis.sw.hospital.utils.SqlQueryExecutor;

import java.util.Map;

import static java.util.Arrays.asList;

@Component
public class ArgumentsVerifierDaoImpl implements ArgumentsVerifierDao {

    @Autowired
    private SqlQueryExecutor mSqlQueryExecutor;

    @Autowired
    private ParamsMapper mParamsMapper;

    @Override
    public void verifyLogin(String login, String password) {
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("login", "password"),asList(login, password));
        int addressCount = mSqlQueryExecutor.queryForInt(Constants.SQL_EXIST_LOGIN_BY_LOGIN_PASSWORD, paramMap);
        if (addressCount != 1) {
            throw new IllegalArgumentException("login = " + login);
        }
    }
}

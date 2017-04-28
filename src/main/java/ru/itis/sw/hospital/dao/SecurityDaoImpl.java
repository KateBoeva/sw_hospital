package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itis.sw.hospital.models.*;
import ru.itis.sw.hospital.models.dto.LoginInfoDto;
import ru.itis.sw.hospital.repository.ArgumentsVerifierDao;
import ru.itis.sw.hospital.utils.Constants;
import ru.itis.sw.hospital.utils.ParamsMapper;
import ru.itis.sw.hospital.utils.SqlQueryExecutor;
import ru.itis.sw.hospital.repository.SecurityDao;

import java.util.Map;

import static java.util.Arrays.asList;

@Repository
public class SecurityDaoImpl implements SecurityDao {

    @Autowired
    ArgumentsVerifierDao mArgumentsVerifierDao;

    @Autowired
    private SqlQueryExecutor mSqlQueryExecutor;

    @Autowired
    private ParamsMapper mParamsMapper;

    @Override
    public boolean addUser(LoginInfoDto loginInfoDto) {
        try {
            mArgumentsVerifierDao.verifyLogin(loginInfoDto.getLogin(), loginInfoDto.getPassword());
            return false;
        } catch (IllegalArgumentException e) {
            Map<String, Object> paramMap = mParamsMapper.asMap(asList("login", "password"),
                    asList(loginInfoDto.getLogin(), loginInfoDto.getPassword()));
            mSqlQueryExecutor.updateQuery(Constants.SQL_ADD_USER, paramMap);
            return true;
        }
    }

    @Override
    public TokenObject auth(LoginInfoDto loginInfoDto) {
        try {
            mArgumentsVerifierDao.verifyLogin(loginInfoDto.getLogin(), loginInfoDto.getPassword());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Login/password incorrect");
        }
        Map<String, Object> paramMap = mParamsMapper.asMap(asList("login", "password"),
                asList(loginInfoDto.getLogin(), loginInfoDto.getPassword()));
        int status = mSqlQueryExecutor.queryForInt(Constants.SQL_GET_STATUS_BY_LOGIN_PASSWORD, paramMap);
        return new TokenObject(status==1?"6c7ca345f63f835cb353ff15bd6c5e052ec08e7a":"9c031d62a3c4909b216e1d86b7f69b982bdca0f9", status);
    }
}

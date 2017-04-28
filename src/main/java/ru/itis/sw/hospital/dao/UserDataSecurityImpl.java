package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.dao.utils.ParamsMapper;
import ru.itis.sw.hospital.dao.utils.SqlQueryExecutor;

import java.util.Map;

import static java.util.Arrays.asList;

@Component
public class UserDataSecurityImpl implements UserDataSecurity {

    @Autowired
    private SqlQueryExecutor mSqlQueryExecutor;

    @Autowired
    private ParamsMapper mParamsMapper;

    @Override
    public boolean verifyToken(String token) {
        if(token.equals("6c7ca345f63f835cb353ff15bd6c5e052ec08e7a"))
            return true;
        if(token.equals("9c031d62a3c4909b216e1d86b7f69b982bdca0f9"))
            return true;
        return false;
    }

    @Override
    public boolean verifyAdminToken(String token) {
        if(token.equals("6c7ca345f63f835cb353ff15bd6c5e052ec08e7a"))
            return true;
        return false;
    }

    @Override
    public boolean isEmpty(String s) {
        return s == null || s.equals("");
    }
}

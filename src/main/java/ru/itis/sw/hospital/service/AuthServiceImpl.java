package ru.itis.sw.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.repository.*;
import ru.itis.sw.hospital.models.*;
import ru.itis.sw.hospital.models.dto.*;

import static java.lang.Integer.parseInt;

@Component
public class AuthServiceImpl implements AuthService {

    @Autowired
    private SecurityDao mSecurityDao;

    @Override
    public boolean register(LoginInfoDto loginInfoDto) {
        return mSecurityDao.addUser(loginInfoDto);
    }

    @Override
    public TokenObject auth(LoginInfoDto loginInfoDto) {
        return mSecurityDao.auth(loginInfoDto);
    }
}

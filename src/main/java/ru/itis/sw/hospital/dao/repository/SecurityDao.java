package ru.itis.sw.hospital.dao.repository;

import ru.itis.sw.hospital.dao.models.*;
import ru.itis.sw.hospital.dao.models.dto.LoginInfoDto;

public interface SecurityDao {

    boolean addUser(LoginInfoDto loginInfoDto);

    TokenObject auth(LoginInfoDto loginInfoDto);
}

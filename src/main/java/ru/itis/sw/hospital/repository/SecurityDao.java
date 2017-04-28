package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.*;
import ru.itis.sw.hospital.models.dto.LoginInfoDto;

public interface SecurityDao {

    boolean addUser(LoginInfoDto loginInfoDto);

    TokenObject auth(LoginInfoDto loginInfoDto);
}

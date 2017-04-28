package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.TokenObject;
import ru.itis.sw.hospital.models.dto.*;

import java.util.List;

public interface AuthService {

    boolean register(LoginInfoDto loginInfoDto);

    TokenObject auth(LoginInfoDto loginInfoDto);
}

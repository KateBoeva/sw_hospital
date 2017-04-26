package ru.itis.sw.hospital.dao;

public interface UserDataSecurity {

    boolean verifyToken(String token);

}

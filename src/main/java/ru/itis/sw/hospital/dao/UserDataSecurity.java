package ru.itis.sw.hospital.dao;

public interface UserDataSecurity {

    boolean verifyToken(String token);

    boolean verifyAdminToken(String token);

    boolean isEmpty(String s);

}

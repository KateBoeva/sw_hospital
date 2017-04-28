package ru.itis.sw.hospital.repository;

public interface UserDataSecurity {

    boolean verifyToken(String token);

    boolean verifyAdminToken(String token);

    boolean isEmpty(String s);

}

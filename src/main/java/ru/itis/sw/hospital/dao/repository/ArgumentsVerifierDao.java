package ru.itis.sw.hospital.dao.repository;

public interface ArgumentsVerifierDao {

    void verifyLogin(String login, String password);

}

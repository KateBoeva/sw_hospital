package ru.itis.sw.hospital.repository;

public interface ArgumentsVerifierDao {

    void verifyLogin(String login, String password);

}

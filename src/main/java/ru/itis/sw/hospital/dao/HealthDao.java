package ru.itis.sw.hospital.dao;

import ru.itis.sw.hospital.dao.models.*;
import ru.itis.sw.hospital.dao.models.dto.LoginInfoDto;

import java.util.List;

public interface HealthDao {

    TokenObject auth(LoginInfoDto loginInfoDto);

    List<City> getCitites();

    List<Hospital> getHospitals(int cityId);

    List<Doctor> getDoctors(int hospitalId);

    Timetable getTimetable(int doctorId);
}

package ru.itis.sw.hospital.service;

import ru.itis.sw.hospital.dao.models.TokenObject;
import ru.itis.sw.hospital.dao.models.dto.*;

import java.util.List;

public interface HealthService {

    String hi();

    TokenObject auth(LoginInfoDto loginInfoDto);

    List<CityDto> getCitites();

    List<HospitalDto> getHospitals(int cityId);

    List<DoctorDto> getDoctors(int hospitalId);

    TimetableDto getTimetable(int doctorId);
}

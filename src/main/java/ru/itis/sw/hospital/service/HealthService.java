package ru.itis.sw.hospital.service;

import ru.itis.sw.hospital.dao.models.Timetable;
import ru.itis.sw.hospital.dao.models.TokenObject;
import ru.itis.sw.hospital.dao.models.dto.*;

import java.util.List;

public interface HealthService {

    boolean register(LoginInfoDto loginInfoDto);

    TokenObject auth(LoginInfoDto loginInfoDto);

    List<CityDto> getCities();

    CityDto getCity(int id);

    List<HospitalDto> getHospitals(int cityId);

    HospitalDto getHospital(int id);

    List<DoctorDto> getDoctors(int hospitalId);

    DoctorDto getDoctor(int id);

    TimetableDto getTimetable(int doctorId);

    void addCity(CityDto dtoCity);

    void addHospital(HospitalDto dtoHospital, int cityId);

    void addDoctor(DoctorDto dtoDoctor, int cityId, int hospitalId);

    void changeTimetable(TimetableDto dtoTimetable, int doctorId);
}

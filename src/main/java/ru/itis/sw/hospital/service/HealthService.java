package ru.itis.sw.hospital.service;

import ru.itis.sw.hospital.dao.models.dto.CityDto;
import ru.itis.sw.hospital.dao.models.dto.DoctorDto;
import ru.itis.sw.hospital.dao.models.dto.HospitalDto;
import ru.itis.sw.hospital.dao.models.dto.TimetableDto;

import java.util.List;

public interface HealthService {

    String hi();

    List<CityDto> getCitites();

    List<HospitalDto> getHospitals(int cityId);

    List<DoctorDto> getDoctors(int hospitalId);

    TimetableDto getTimetable(int doctorId);
}

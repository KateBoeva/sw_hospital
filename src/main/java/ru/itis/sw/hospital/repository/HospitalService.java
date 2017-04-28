package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.TokenObject;
import ru.itis.sw.hospital.models.dto.HospitalDto;
import ru.itis.sw.hospital.models.dto.LoginInfoDto;
import ru.itis.sw.hospital.models.dto.TimetableDto;

import java.util.List;

public interface HospitalService {

    List<HospitalDto> getHospitals(int cityId);

    HospitalDto getHospital(int id);

    void addHospital(HospitalDto dtoHospital, int cityId);

    void deleteHospital(int id);
}

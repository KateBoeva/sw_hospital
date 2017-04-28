package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.Hospital;

import java.util.List;

public interface HospitalDao {

    List<Hospital> getHospitals(int cityId);

    Hospital getHospital(int id);

    void addHospital(Hospital hospital);

    void deleteHospital(int id);
}

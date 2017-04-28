package ru.itis.sw.hospital.dao.repository;

import ru.itis.sw.hospital.dao.models.Hospital;

import java.util.List;

public interface HospitalDao {

    List<Hospital> getHospitals(int cityId);

    void addHospital(Hospital hospital);
}
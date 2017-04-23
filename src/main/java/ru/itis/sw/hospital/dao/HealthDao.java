package ru.itis.sw.hospital.dao;

import ru.itis.sw.hospital.dao.models.City;
import ru.itis.sw.hospital.dao.models.Doctor;
import ru.itis.sw.hospital.dao.models.Hospital;

import java.util.List;

public interface HealthDao {

    List<City> getCitites();

    List<Hospital> getHospitals(int cityId);

    List<Doctor> getDoctors(int hospitalId);
}

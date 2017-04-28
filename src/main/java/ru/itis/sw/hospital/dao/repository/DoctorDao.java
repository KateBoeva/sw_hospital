package ru.itis.sw.hospital.dao.repository;

import ru.itis.sw.hospital.dao.models.Doctor;

import java.util.List;

public interface DoctorDao {

    List<Doctor> getDoctors(int hospitalId);

    Doctor getDoctor(int id);

    void addDoctor(Doctor doctor);
}

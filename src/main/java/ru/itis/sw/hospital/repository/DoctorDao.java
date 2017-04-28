package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.Doctor;

import java.util.List;

public interface DoctorDao {

    List<Doctor> getDoctors(int hospitalId);

    Doctor getDoctor(int id);

    void addDoctor(Doctor doctor);

    void deleteDoctor(int id);
}

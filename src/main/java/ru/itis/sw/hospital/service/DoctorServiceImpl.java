package ru.itis.sw.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.models.Doctor;
import ru.itis.sw.hospital.models.dto.DoctorDto;
import ru.itis.sw.hospital.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao mDoctorDao;

    @Override
    public List<DoctorDto> getDoctors(int hospitalId) {
        List<Doctor> doctors = mDoctorDao.getDoctors(hospitalId);

        List<DoctorDto> dtoDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            dtoDoctors.add(new DoctorDto(doctor.getId(), doctor.getName(), doctor.getSurname(), doctor.getCityId(), doctor.getHospitalId(),
                    doctor.getSpecialization(), doctor.getExperience(), doctor.getRegalies(), doctor.getPhone(),
                    doctor.getPatronymic()));
        }
        return dtoDoctors;
    }

    @Override
    public DoctorDto getDoctor(int id) {
        Doctor doctor = mDoctorDao.getDoctor(id);
        return new DoctorDto(doctor.getId(), doctor.getName(), doctor.getSurname(), doctor.getCityId(), doctor.getHospitalId(),
                    doctor.getSpecialization(), doctor.getExperience(), doctor.getRegalies(), doctor.getPhone(),
                    doctor.getPatronymic());
    }

    @Override
    public void addDoctor(DoctorDto dtoDoctor, int cityId, int hospitalId) {
        Doctor doctor = new Doctor(0, dtoDoctor.getName(), dtoDoctor.getSurname(), cityId, hospitalId,
                dtoDoctor.getSpecialization(), dtoDoctor.getExperience(), dtoDoctor.getRegalies(), dtoDoctor.getPhone(),
                dtoDoctor.getPatronymic());
        mDoctorDao.addDoctor(doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        mDoctorDao.deleteDoctor(id);
    }
}

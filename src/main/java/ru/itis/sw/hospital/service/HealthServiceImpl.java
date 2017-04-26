package ru.itis.sw.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.dao.HealthDao;
import ru.itis.sw.hospital.dao.models.*;
import ru.itis.sw.hospital.dao.models.dto.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class HealthServiceImpl implements HealthService {


    @Autowired
    private HealthDao mHealthDao;

    @Override
    public String hi(){
        return "Hello";
    }

    @Override
    public TokenObject auth(LoginInfoDto loginInfoDto) {
        return mHealthDao.auth(loginInfoDto);
    }

    @Override
    public List<CityDto> getCitites() {
        List<City> cities = mHealthDao.getCitites();

        List<CityDto> dtoCities = new ArrayList<>();
        for (City city : cities) {
            dtoCities.add(new CityDto(city.getId(), city.getName()));
        }
        return dtoCities;
    }

    @Override
    public List<HospitalDto> getHospitals(int cityId) {
        List<Hospital> hospitals = mHealthDao.getHospitals(cityId);

        List<HospitalDto> dtoHospitals = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            dtoHospitals.add(new HospitalDto(hospital.getId(), hospital.getName(), hospital.getAddress(), hospital.getCityId()));
        }
        return dtoHospitals;
    }

    @Override
    public List<DoctorDto> getDoctors(int hospitalId) {
        List<Doctor> doctors = mHealthDao.getDoctors(hospitalId);

        List<DoctorDto> dtoDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            dtoDoctors.add(new DoctorDto(doctor.getId(), doctor.getName(), doctor.getSurname(), doctor.getCityId(), doctor.getHospitalId(),
                    doctor.getSpecialization(), doctor.getExperience(), doctor.getRegalies(), doctor.getPhone(),
                    doctor.getPatronymic()));
        }
        return dtoDoctors;
    }

    @Override
    public TimetableDto getTimetable(int doctorId) {
        Timetable timetable = mHealthDao.getTimetable(doctorId);

        return new TimetableDto(timetable.getId(), timetable.getDoctorId(), timetable.getMonday(),
                timetable.getTuesday(), timetable.getWednesday(), timetable.getThursday(),
                timetable.getFriday(), timetable.getSaturday(), timetable.getSunday());
    }
}

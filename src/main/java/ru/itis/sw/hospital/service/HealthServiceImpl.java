package ru.itis.sw.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.dao.repository.*;
import ru.itis.sw.hospital.dao.models.*;
import ru.itis.sw.hospital.dao.models.dto.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Component
public class HealthServiceImpl implements HealthService {


    @Autowired
    private SecurityDao mSecurityDao;

    @Autowired
    private CityDao mCityDao;

    @Autowired
    private HospitalDao mHospitalDao;

    @Autowired
    private TimetableDao mTimetableDao;

    @Autowired
    private DoctorDao mDoctorDao;

    @Override
    public boolean register(LoginInfoDto loginInfoDto) {
        return mSecurityDao.addUser(loginInfoDto);
    }

    @Override
    public TokenObject auth(LoginInfoDto loginInfoDto) {
        return mSecurityDao.auth(loginInfoDto);
    }

    @Override
    public List<CityDto> getCitites() {
        List<City> cities = mCityDao.getCitites();

        List<CityDto> dtoCities = new ArrayList<>();
        for (City city : cities) {
            dtoCities.add(new CityDto(city.getId(), city.getName()));
        }
        return dtoCities;
    }

    @Override
    public List<HospitalDto> getHospitals(int cityId) {
        List<Hospital> hospitals = mHospitalDao.getHospitals(cityId);

        List<HospitalDto> dtoHospitals = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            dtoHospitals.add(new HospitalDto(hospital.getId(), hospital.getName(), hospital.getAddress(), hospital.getCityId()));
        }
        return dtoHospitals;
    }

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
    public TimetableDto getTimetable(int doctorId) {
        Timetable timetable = mTimetableDao.getTimetable(doctorId);


        return new TimetableDto(timetable.getId(), timetable.getDoctorId(), timetable.getMonday(),
                timetable.getTuesday(), timetable.getWednesday(), timetable.getThursday(),
                timetable.getFriday(), timetable.getSaturday(), timetable.getSunday());
    }

    @Override
    public void addCity(CityDto dtoCity) {
        City city = new City(0, dtoCity.getName());
        mCityDao.addCity(city);
    }

    @Override
    public void addHospital(HospitalDto dtoHospital, int cityId) {
        Hospital hospital = new Hospital(0, dtoHospital.getName(), dtoHospital.getAddress(), cityId);
        mHospitalDao.addHospital(hospital);
    }

    @Override
    public void addDoctor(DoctorDto dtoDoctor, int cityId, int hospitalId) {
        Doctor doctor = new Doctor(0, dtoDoctor.getName(), dtoDoctor.getSurname(), cityId, hospitalId,
                dtoDoctor.getSpecialization(), dtoDoctor.getExperience(), dtoDoctor.getRegalies(), dtoDoctor.getPhone(),
                dtoDoctor.getPatronymic());
        mDoctorDao.addDoctor(doctor);
    }

    @Override
    public void changeTimetable(TimetableDto dtoTimetable, int doctorId) {
        Timetable timetable = new Timetable(dtoTimetable.getId(), doctorId, dtoTimetable.getMonday(),
                dtoTimetable.getTuesday(), dtoTimetable.getWednesday(), dtoTimetable.getThursday(), dtoTimetable.getFriday(),
                dtoTimetable.getSaturday(), dtoTimetable.getSunday());
        mTimetableDao.changeTimetable(timetable);
    }
}

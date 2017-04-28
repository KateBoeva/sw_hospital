package ru.itis.sw.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.models.Hospital;
import ru.itis.sw.hospital.models.dto.HospitalDto;
import ru.itis.sw.hospital.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalDao mHospitalDao;

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
    public HospitalDto getHospital(int id) {
        Hospital hospital = mHospitalDao.getHospital(id);
        return new HospitalDto(hospital.getId(), hospital.getName(), hospital.getAddress(), hospital.getCityId());
    }

    @Override
    public void addHospital(HospitalDto dtoHospital, int cityId) {
        Hospital hospital = new Hospital(0, dtoHospital.getName(), dtoHospital.getAddress(), cityId);
        mHospitalDao.addHospital(hospital);
    }

    @Override
    public void deleteHospital(int id) {
        mHospitalDao.deleteHospital(id);
    }
}

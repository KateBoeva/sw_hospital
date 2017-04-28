package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.TokenObject;
import ru.itis.sw.hospital.models.dto.*;

import java.util.List;

public interface DoctorService {

    List<DoctorDto> getDoctors(int hospitalId);

    DoctorDto getDoctor(int id);

    void addDoctor(DoctorDto dtoDoctor, int cityId, int hospitalId);

    void deleteDoctor(int id);
}

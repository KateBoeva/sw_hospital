package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.TokenObject;
import ru.itis.sw.hospital.models.dto.*;

import java.util.List;

public interface CityService {

    List<CityDto> getCities();

    CityDto getCity(int id);

    void addCity(CityDto dtoCity);

    void deleteCity(int id);
}

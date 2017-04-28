package ru.itis.sw.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.models.*;
import ru.itis.sw.hospital.models.dto.*;
import ru.itis.sw.hospital.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao mCityDao;

    @Override
    public List<CityDto> getCities() {
        List<City> cities = mCityDao.getCities();

        List<CityDto> dtoCities = new ArrayList<>();
        for (City city : cities) {
            dtoCities.add(new CityDto(city.getId(), city.getName()));
        }
        return dtoCities;
    }

    @Override
    public CityDto getCity(int id) {
        City city = mCityDao.getCity(id);
        return new CityDto(city.getId(), city.getName());
    }

    @Override
    public void addCity(CityDto dtoCity) {
        City city = new City(0, dtoCity.getName());
        mCityDao.addCity(city);
    }

    @Override
    public void deleteCity(int id) {
        mCityDao.deleteCity(id);
    }
}

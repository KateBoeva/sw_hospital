package ru.itis.sw.hospital.dao.repository;

import ru.itis.sw.hospital.dao.models.*;

import java.util.List;

public interface CityDao {

    List<City> getCities();

    City getCity(int id);

    void addCity(City city);
}

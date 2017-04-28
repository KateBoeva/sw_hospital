package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.*;

import java.util.List;

public interface CityDao {

    List<City> getCities();

    City getCity(int id);

    void addCity(City city);

    void deleteCity(int id);
}

package ru.itis.sw.hospital.dao.repository;

import ru.itis.sw.hospital.dao.models.*;

import java.util.List;

public interface CityDao {

    List<City> getCitites();

    void addCity(City city);
}

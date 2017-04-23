package ru.itis.sw.hospital.dao.models.dto;

/**
 * Created by katemrrr on 26.03.17.
 */
public class DoctorDto {

    private int id;
    private String name;
    private String surname;
    private int cityId;
    private int hospitalId;
    private String specialization;
    private String experience;
    private String regalies;
    private String phone;
    private String patronymic;

    public DoctorDto() {
    }

    public DoctorDto(int id, String name, String surname, int cityId, int hospitalId, String specialization, String experience, String regalies, String phone, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cityId = cityId;
        this.hospitalId = hospitalId;
        this.specialization = specialization;
        this.experience = experience;
        this.regalies = regalies;
        this.phone = phone;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getRegalies() {
        return regalies;
    }

    public void setRegalies(String regalies) {
        this.regalies = regalies;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}

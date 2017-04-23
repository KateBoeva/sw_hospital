package ru.itis.sw.hospital.dao.models.dto;

/**
 * Created by katemrrr on 26.03.17.
 */
public class HospitalDto {

    private int id;
    private String name;
    private String address;
    private int cityId;

    public HospitalDto() {
    }

    public HospitalDto(int id, String name, String address, int cityId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cityId = cityId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

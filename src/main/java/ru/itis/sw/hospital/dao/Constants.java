package ru.itis.sw.hospital.dao;

public class Constants {

    static final String SQL_GET_CITIES =
            "SELECT * FROM \"city\"";

    static final String SQL_GET_HOSPITALS_BY_CITY_ID =
            "SELECT * FROM \"hospital\" WHERE id_city = :id_city";

    static final String SQL_GET_DOCTORS_BY_HOSPITAL_ID =
            "SELECT * FROM \"doctor\" WHERE id_hospital = :id_hospital";

    static final String SQL_ADD_CONTACT =
            "INSERT INTO \"Contacts\"(name, number, email, address) " +
                    "VALUES (:name, :number, :email, :address)";

    static final String SQL_UPDATE_CONTACT =
            "UPDATE \"Contacts\" SET name = :name, address = :address, email = :email, number = :number WHERE id = :id";

    static final String SQL_REMOVE_CONTACT =
            "DELETE FROM \"Contacts\" WHERE id = :id";
}

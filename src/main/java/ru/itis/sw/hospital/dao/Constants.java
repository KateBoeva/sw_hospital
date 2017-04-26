package ru.itis.sw.hospital.dao;

public class Constants {

    static final String SQL_GET_CITIES =
            "SELECT * FROM \"city\"";

    static final String SQL_GET_HOSPITALS_BY_CITY_ID =
            "SELECT * FROM \"hospital\" WHERE id_city = :id_city";

    static final String SQL_GET_DOCTORS_BY_HOSPITAL_ID =
            "SELECT * FROM \"doctor\" WHERE id_hospital = :id_hospital";

    static final String SQL_GET_TIMETABLE_BY_DOCTOR_ID =
            "SELECT * FROM \"timetable\" WHERE id_doctor = :id_doctor";

    static final String SQL_EXIST_LOGIN_BY_LOGIN_PASSWORD =
            "SELECT COUNT (*) FROM \"user\" WHERE (login = :login AND password = :password)";

    static final String SQL_GET_ID_BY_LOGIN_PASSWORD =
            "SELECT id FROM \"user\" WHERE (login = :login AND password = :password)";

    static final String SQL_GET_STATUS_BY_LOGIN_PASSWORD =
            "SELECT id FROM \"user\" WHERE (login = :login AND password = :password)";

    static final String SQL_ADD_CONTACT =
            "INSERT INTO \"Contacts\"(name, number, email, address) " +
                    "VALUES (:name, :number, :email, :address)";

    static final String SQL_UPDATE_CONTACT =
            "UPDATE \"Contacts\" SET name = :name, address = :address, email = :email, number = :number WHERE id = :id";

    static final String SQL_REMOVE_CONTACT =
            "DELETE FROM \"Contacts\" WHERE id = :id";
}

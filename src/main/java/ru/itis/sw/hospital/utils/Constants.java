package ru.itis.sw.hospital.utils;

public class Constants {

    public static final String SQL_GET_CITIES =
            "SELECT * FROM \"city\"";

    public static final String SQL_GET_CITY_BY_ID =
            "SELECT * FROM \"city\" where id = :id";

    public static final String SQL_GET_HOSPITALS_BY_CITY_ID =
            "SELECT * FROM \"hospital\" WHERE id_city = :id_city";

    public static final String SQL_GET_HOSPITAL_BY_ID =
            "SELECT * FROM \"hospital\" WHERE id = :id";

    public static final String SQL_GET_DOCTORS_BY_HOSPITAL_ID =
            "SELECT * FROM \"doctor\" WHERE id_hospital = :id_hospital";

    public static final String SQL_GET_DOCTOR_BY_ID =
            "SELECT * FROM \"doctor\" WHERE id = :id";

    public static final String SQL_GET_TIMETABLE_BY_DOCTOR_ID =
            "SELECT * FROM \"timetable\" WHERE id_doctor = :id_doctor";

    public static final String SQL_EXIST_LOGIN_BY_LOGIN_PASSWORD =
            "SELECT COUNT (*) FROM \"users\" WHERE (login = :login AND password = :password)";

    public static final String SQL_GET_STATUS_BY_LOGIN_PASSWORD =
            "SELECT is_admin FROM \"users\" WHERE (login = :login AND password = :password)";

    public static final String SQL_GET_ID_BY_DOCTOR =
            "SELECT id FROM \"doctor\" WHERE (name = :name AND surname = :surname AND patronymic = :patronymic" +
                    " AND specialization = :specialization AND experience = :experience AND regalies = :regalies" +
                    " AND phone = :phone AND id_city = :id_city AND id_hospital = :id_hospital)";

    public static final String SQL_ADD_USER =
            "INSERT INTO \"users\"(login, password) " +
                    "VALUES (:login, :password)";

    public static final String SQL_ADD_CITY =
            "INSERT INTO \"city\"(name) " +
                    "VALUES (:name)";

    public static final String SQL_ADD_HOSPITAL =
            "INSERT INTO \"hospital\"(name, address, id_city) " +
                    "VALUES (:name, :address, :id_city)";

    public static final String SQL_ADD_DOCTOR =
            "INSERT INTO \"doctor\"(name, surname, id_city, id_hospital, specialization, experience, regalies, phone, patronymic) " +
                    "VALUES (:name, :surname, :id_city, :id_hospital, :specialization, :experience, :regalies, :phone, :patronymic)";

    public static final String SQL_ADD_TIMETABLE =
            "INSERT INTO \"timetable\"(id_doctor) " +
                    "VALUES (:id_doctor)";

    public static final String SQL_UPDATE_TIMETABLE =
            "UPDATE \"timetable\" SET monday = :monday, tuesday = :tuesday, wednesday = :wednesday, thursday = :thursday, friday = :friday, saturday = :saturday, sunday = :sunday WHERE id_doctor = :id_doctor";

    public static final String SQL_DELETE_CITY =
            "DELETE FROM \"city\" WHERE id = :id";

    public static final String SQL_DELETE_HOSPITAL =
            "DELETE FROM \"hospital\" WHERE id = :id";

    public static final String SQL_DELETE_DOCTOR =
            "DELETE FROM \"doctor\" WHERE id = :id";
}

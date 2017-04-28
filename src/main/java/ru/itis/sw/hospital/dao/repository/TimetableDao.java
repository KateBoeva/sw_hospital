package ru.itis.sw.hospital.dao.repository;

import ru.itis.sw.hospital.dao.models.Timetable;

public interface TimetableDao {


    Timetable getTimetable(int doctorId);

    void addTimetable(int doctorId);

    void changeTimetable(Timetable timetable);
}

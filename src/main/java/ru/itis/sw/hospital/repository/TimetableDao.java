package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.Timetable;

public interface TimetableDao {


    Timetable getTimetable(int doctorId);

    void addTimetable(int doctorId);

    void changeTimetable(Timetable timetable);
}

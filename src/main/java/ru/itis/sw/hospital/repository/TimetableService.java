package ru.itis.sw.hospital.repository;

import ru.itis.sw.hospital.models.TokenObject;
import ru.itis.sw.hospital.models.dto.LoginInfoDto;
import ru.itis.sw.hospital.models.dto.TimetableDto;

public interface TimetableService {

    TimetableDto getTimetable(int doctorId);

    void changeTimetable(TimetableDto dtoTimetable, int doctorId);
}

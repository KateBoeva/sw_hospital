package ru.itis.sw.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.models.Timetable;
import ru.itis.sw.hospital.models.dto.TimetableDto;
import ru.itis.sw.hospital.repository.TimetableDao;
import ru.itis.sw.hospital.repository.TimetableService;

@Component
public class TimetableServiceImpl implements TimetableService {

    @Autowired
    private TimetableDao mTimetableDao;

    @Override
    public TimetableDto getTimetable(int doctorId) {
        Timetable timetable = mTimetableDao.getTimetable(doctorId);


        return new TimetableDto(timetable.getId(), timetable.getDoctorId(), timetable.getMonday(),
                timetable.getTuesday(), timetable.getWednesday(), timetable.getThursday(),
                timetable.getFriday(), timetable.getSaturday(), timetable.getSunday());
    }

    @Override
    public void changeTimetable(TimetableDto dtoTimetable, int doctorId) {
        Timetable timetable = new Timetable(dtoTimetable.getId(), doctorId, dtoTimetable.getMonday(),
                dtoTimetable.getTuesday(), dtoTimetable.getWednesday(), dtoTimetable.getThursday(), dtoTimetable.getFriday(),
                dtoTimetable.getSaturday(), dtoTimetable.getSunday());
        mTimetableDao.changeTimetable(timetable);
    }
}

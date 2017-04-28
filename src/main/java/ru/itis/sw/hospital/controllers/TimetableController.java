package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.repository.UserDataSecurity;
import ru.itis.sw.hospital.models.dto.*;
import ru.itis.sw.hospital.repository.TimetableService;

@RestController
@CrossOrigin("*")
public class TimetableController {

    @Autowired
    private TimetableService mTimetableService;

    @Autowired
    private UserDataSecurity mUserDataSecurity;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctors/{id_doctor}/timetable", method = RequestMethod.GET)
    public ResponseEntity<TimetableDto> getTimetable(@RequestHeader(value = "ORIGIN") String origin,
                                                     @PathVariable("id_city") int cityId,
                                                     @PathVariable("id_hospital") int hospitalId,
                                                     @PathVariable("id_doctor") int doctorId,
                                                     @RequestParam("token") String token){
        if(mUserDataSecurity.verifyToken(token))
            return new ResponseEntity<TimetableDto>(mTimetableService.getTimetable(doctorId), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctors/{id_doctor}/timetable", method = RequestMethod.POST)
    public ResponseEntity changeTimetabe(@RequestHeader(value = "ORIGIN") String origin,
                                         @PathVariable("id_city") int cityId,
                                         @PathVariable("id_hospital") int hospitalId,
                                         @PathVariable("id_doctor") int doctorId,
                                         @RequestBody TimetableDto dtoTimetable,
                                         @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token)) {
            mTimetableService.changeTimetable(dtoTimetable, doctorId);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}

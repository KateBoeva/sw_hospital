package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.dao.UserDataSecurity;
import ru.itis.sw.hospital.dao.models.TokenObject;
import ru.itis.sw.hospital.dao.models.dto.*;
import ru.itis.sw.hospital.service.HealthService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TimetableController {

    @Autowired
    private HealthService mHealthService;

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
            return new ResponseEntity<TimetableDto>(mHealthService.getTimetable(doctorId), HttpStatus.OK);
        else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}

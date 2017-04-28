package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.dao.UserDataSecurity;
import ru.itis.sw.hospital.dao.models.dto.DoctorDto;
import ru.itis.sw.hospital.dao.models.dto.TimetableDto;
import ru.itis.sw.hospital.service.HealthService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private HealthService mHealthService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctors", method = RequestMethod.GET)
    public ResponseEntity<List<DoctorDto>> getDoctors(@RequestHeader(value = "ORIGIN") String origin,
                                                      @PathVariable("id_city") int cityId,
                                                      @PathVariable("id_hospital") int hospitalId){
        return new ResponseEntity<List<DoctorDto>>(mHealthService.getDoctors(hospitalId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctor/{id_doctor}", method = RequestMethod.GET)
    public ResponseEntity<DoctorDto> getDoctor(@RequestHeader(value = "ORIGIN") String origin,
                                               @PathVariable("id_city") int cityId,
                                               @PathVariable("id_hospital") int hospitalId,
                                               @PathVariable("id_doctor") int doctorId){
        return new ResponseEntity<DoctorDto>(mHealthService.getDoctor(hospitalId), HttpStatus.OK);
    }
}

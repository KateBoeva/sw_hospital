package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.dao.UserDataSecurity;
import ru.itis.sw.hospital.dao.models.dto.DoctorDto;
import ru.itis.sw.hospital.dao.models.dto.HospitalDto;
import ru.itis.sw.hospital.dao.models.dto.TimetableDto;
import ru.itis.sw.hospital.service.HealthService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class HospitalController {

    @Autowired
    private HealthService mHealthService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals", method = RequestMethod.GET)
    public ResponseEntity<List<HospitalDto>> getHospitals(@RequestHeader(value = "ORIGIN") String origin,
                                                          @PathVariable("id_city") int cityId){
        return new ResponseEntity<List<HospitalDto>>(mHealthService.getHospitals(cityId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospital/{id_hospital}", method = RequestMethod.GET)
    public ResponseEntity<HospitalDto> getHospital(@RequestHeader(value = "ORIGIN") String origin,
                                                   @PathVariable("id_city") int cityId,
                                                   @PathVariable("id_hospital") int hospitalId){
        return new ResponseEntity<HospitalDto>(mHealthService.getHospital(cityId), HttpStatus.OK);
    }
}

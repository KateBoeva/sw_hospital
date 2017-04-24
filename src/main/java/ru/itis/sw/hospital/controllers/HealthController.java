package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.dao.models.dto.CityDto;
import ru.itis.sw.hospital.dao.models.dto.DoctorDto;
import ru.itis.sw.hospital.dao.models.dto.HospitalDto;
import ru.itis.sw.hospital.dao.models.dto.TimetableDto;
import ru.itis.sw.hospital.service.HealthService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class HealthController {

    @Autowired
    private HealthService mHealthService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hi(){
        return new ResponseEntity<String>(mHealthService.hi(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities", method = RequestMethod.GET)
    public ResponseEntity<List<CityDto>> getCities(@RequestHeader(value = "ORIGIN") String origin){
        return new ResponseEntity<List<CityDto>>(mHealthService.getCitites(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals", method = RequestMethod.GET)
    public ResponseEntity<List<HospitalDto>> getHospitals(@RequestHeader(value = "ORIGIN") String origin,
                                                          @PathVariable("id_city") int cityId){
        return new ResponseEntity<List<HospitalDto>>(mHealthService.getHospitals(cityId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctors", method = RequestMethod.GET)
    public ResponseEntity<List<DoctorDto>> getHospitals(@RequestHeader(value = "ORIGIN") String origin,
                                                        @PathVariable("id_city") int cityId,
                                                        @PathVariable("id_hospital") int hospitalId){
        return new ResponseEntity<List<DoctorDto>>(mHealthService.getDoctors(hospitalId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctors/{id_doctor}/timetable", method = RequestMethod.GET)
    public ResponseEntity<TimetableDto> getTimetable(@RequestHeader(value = "ORIGIN") String origin,
                                                     @PathVariable("id_city") int cityId,
                                                     @PathVariable("id_hospital") int hospitalId,
                                                     @PathVariable("id_doctor") int doctorId){
        return new ResponseEntity<TimetableDto>(mHealthService.getTimetable(doctorId), HttpStatus.OK);
    }
}

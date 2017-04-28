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
public class HealthController {

    @Autowired
    private HealthService mHealthService;

    @Autowired
    private UserDataSecurity mUserDataSecurity;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<TokenObject> auth(@RequestHeader(value = "ORIGIN") String origin,
                                            @RequestBody LoginInfoDto loginInfoDto){
        return new ResponseEntity<TokenObject>(mHealthService.auth(loginInfoDto), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestHeader(value = "ORIGIN") String origin,
                                            @RequestBody LoginInfoDto loginInfoDto){
        if(mHealthService.register(loginInfoDto))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/admin/cities", method = RequestMethod.POST)
    public ResponseEntity addCity(@RequestHeader(value = "ORIGIN") String origin,
                                  @RequestBody CityDto dtoCity,
                                  @RequestParam("token") String token){

        if(mUserDataSecurity.verifyAdminToken(token) && !mUserDataSecurity.isEmpty(dtoCity.getName())) {
            mHealthService.addCity(dtoCity);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/admin/cities/{id_city}/hospitals", method = RequestMethod.POST)
    public ResponseEntity addHospital(@RequestHeader(value = "ORIGIN") String origin,
                                      @PathVariable("id_city") int cityId,
                                      @RequestBody HospitalDto dtoHospital,
                                      @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token) && !mUserDataSecurity.isEmpty(dtoHospital.getName()) && !mUserDataSecurity.isEmpty(dtoHospital.getAddress())) {
            mHealthService.addHospital(dtoHospital, cityId);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/admin/cities/{id_city}/hospitals/{id_hospital}/doctors", method = RequestMethod.POST)
    public ResponseEntity addDoctor(@RequestHeader(value = "ORIGIN") String origin,
                                    @PathVariable("id_city") int cityId,
                                    @PathVariable("id_hospital") int hospitalId,
                                    @RequestBody DoctorDto dtoDoctor,
                                    @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token) && !mUserDataSecurity.isEmpty(dtoDoctor.getName())
                && !mUserDataSecurity.isEmpty(dtoDoctor.getSurname()) && !mUserDataSecurity.isEmpty(dtoDoctor.getSpecialization())
                && !mUserDataSecurity.isEmpty(dtoDoctor.getExperience()) && !mUserDataSecurity.isEmpty(dtoDoctor.getRegalies())
                && !mUserDataSecurity.isEmpty(dtoDoctor.getPhone()) && !mUserDataSecurity.isEmpty(dtoDoctor.getPatronymic())) {
            mHealthService.addDoctor(dtoDoctor, cityId, hospitalId);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/admin/cities/{id_city}/hospitals/{id_hospital}/doctors/{id_doctor}/timetable", method = RequestMethod.POST)
    public ResponseEntity changeTimetabe(@RequestHeader(value = "ORIGIN") String origin,
                                    @PathVariable("id_city") int cityId,
                                    @PathVariable("id_hospital") int hospitalId,
                                    @PathVariable("id_doctor") int doctorId,
                                    @RequestBody TimetableDto dtoTimetable,
                                    @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token)) {
            mHealthService.changeTimetable(dtoTimetable, doctorId);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
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
    public ResponseEntity<List<DoctorDto>> getВщсещкs(@RequestHeader(value = "ORIGIN") String origin,
                                                        @PathVariable("id_city") int cityId,
                                                        @PathVariable("id_hospital") int hospitalId){
        return new ResponseEntity<List<DoctorDto>>(mHealthService.getDoctors(hospitalId), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/timetable/{id_doctor}", method = RequestMethod.GET)
    public ResponseEntity<TimetableDto> getTimetable(@RequestHeader(value = "ORIGIN") String origin,
                                                     @PathVariable("id_doctor") int doctorId,
                                                     @RequestParam("token") String token){
        if(mUserDataSecurity.verifyToken(token))
            return new ResponseEntity<TimetableDto>(mHealthService.getTimetable(doctorId), HttpStatus.OK);
        else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}

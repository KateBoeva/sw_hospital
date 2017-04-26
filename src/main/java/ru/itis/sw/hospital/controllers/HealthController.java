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
    @RequestMapping(value = "/health/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hi(){
        return new ResponseEntity<String>(mHealthService.hi(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<TokenObject> auth(@RequestHeader(value = "ORIGIN") String origin,
                                            @RequestBody LoginInfoDto loginInfoDto){
        return new ResponseEntity<TokenObject>(mHealthService.auth(loginInfoDto), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/admin/cities", method = RequestMethod.POST)
    public ResponseEntity addCity(@RequestHeader(value = "ORIGIN") String origin,
                                  @RequestBody CityDto dtoCity,
                                  @RequestBody String token){
        if(mUserDataSecurity.verifyToken(token))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/admin/cities/{id_city}/hospitals", method = RequestMethod.POST)
    public ResponseEntity addHospital(@RequestHeader(value = "ORIGIN") String origin,
                                      @PathVariable("id_city") int cityId,
                                      @RequestBody HospitalDto dtoHospital,
                                      @RequestBody String token){
        if(mUserDataSecurity.verifyToken(token))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/admin/cities/{id_city}/hospitals/{id_hospital}/doctors", method = RequestMethod.POST)
    public ResponseEntity addDoctor(@RequestHeader(value = "ORIGIN") String origin,
                                    @PathVariable("id_city") int cityId,
                                    @PathVariable("id_hospital") int hospitalId,
                                    @RequestBody DoctorDto dtoDoctor,
                                    @RequestBody String token){
        if(mUserDataSecurity.verifyToken(token))
            return new ResponseEntity(HttpStatus.OK);
        else
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
    public ResponseEntity<List<DoctorDto>> getHospitals(@RequestHeader(value = "ORIGIN") String origin,
                                                        @PathVariable("id_city") int cityId,
                                                        @PathVariable("id_hospital") int hospitalId){
        return new ResponseEntity<List<DoctorDto>>(mHealthService.getDoctors(hospitalId), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/timetable/{id_doctor}/{token}", method = RequestMethod.GET)
    public ResponseEntity<TimetableDto> getTimetable(@RequestHeader(value = "ORIGIN") String origin,
                                                     @PathVariable("id_doctor") int doctorId,
                                                     @PathVariable("token") String token){
        if(mUserDataSecurity.verifyToken(token))
            return new ResponseEntity<TimetableDto>(mHealthService.getTimetable(doctorId), HttpStatus.OK);
        else
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}

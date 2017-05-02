package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.repository.UserDataSecurity;
import ru.itis.sw.hospital.models.dto.HospitalDto;
import ru.itis.sw.hospital.repository.HospitalService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class HospitalController {

    @Autowired
    private HospitalService mHospitalService;

    @Autowired
    private UserDataSecurity mUserDataSecurity;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals", method = RequestMethod.GET)
    public ResponseEntity<List<HospitalDto>> getHospitals(@RequestHeader(value = "ORIGIN") String origin,
                                                          @PathVariable("id_city") int cityId){
        return new ResponseEntity<List<HospitalDto>>(mHospitalService.getHospitals(cityId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}", method = RequestMethod.GET)
    public ResponseEntity<HospitalDto> getHospital(@RequestHeader(value = "ORIGIN") String origin,
                                                   @PathVariable("id_city") int cityId,
                                                   @PathVariable("id_hospital") int hospitalId){
        return new ResponseEntity<HospitalDto>(mHospitalService.getHospital(cityId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals", method = RequestMethod.POST)
    public ResponseEntity addHospital(@RequestHeader(value = "ORIGIN") String origin,
                                      @PathVariable("id_city") int cityId,
                                      @RequestBody HospitalDto dtoHospital,
                                      @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token) && !mUserDataSecurity.isEmpty(dtoHospital.getName()) && !mUserDataSecurity.isEmpty(dtoHospital.getAddress())) {
            mHospitalService.addHospital(dtoHospital, cityId);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}", method = RequestMethod.DELETE)
    public ResponseEntity<List<HospitalDto>> deleteHospital(@RequestHeader(value = "ORIGIN") String origin,
                                         @PathVariable("id_city") int cityId,
                                         @PathVariable("id_hospital") int hospitalId,
                                         @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token)) {
            mHospitalService.deleteHospital(hospitalId);
            return new ResponseEntity<List<HospitalDto>>(mHospitalService.getHospitals(cityId), HttpStatus.OK);
        } else
            return new ResponseEntity<List<HospitalDto>>(HttpStatus.NOT_FOUND);
    }
}

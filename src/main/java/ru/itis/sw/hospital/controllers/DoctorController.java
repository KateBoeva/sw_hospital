package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.repository.UserDataSecurity;
import ru.itis.sw.hospital.models.dto.DoctorDto;
import ru.itis.sw.hospital.repository.DoctorService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private DoctorService mDoctorService;

    @Autowired
    private UserDataSecurity mUserDataSecurity;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctors", method = RequestMethod.GET)
    public ResponseEntity<List<DoctorDto>> getDoctors(@RequestHeader(value = "ORIGIN") String origin,
                                                      @PathVariable("id_city") int cityId,
                                                      @PathVariable("id_hospital") int hospitalId){
        return new ResponseEntity<List<DoctorDto>>(mDoctorService.getDoctors(hospitalId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctors/{id_doctor}", method = RequestMethod.GET)
    public ResponseEntity<DoctorDto> getDoctor(@RequestHeader(value = "ORIGIN") String origin,
                                               @PathVariable("id_city") int cityId,
                                               @PathVariable("id_hospital") int hospitalId,
                                               @PathVariable("id_doctor") int doctorId){
        return new ResponseEntity<DoctorDto>(mDoctorService.getDoctor(hospitalId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctors", method = RequestMethod.POST)
    public ResponseEntity addDoctor(@RequestHeader(value = "ORIGIN") String origin,
                                    @PathVariable("id_city") int cityId,
                                    @PathVariable("id_hospital") int hospitalId,
                                    @RequestBody DoctorDto dtoDoctor,
                                    @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token) && !mUserDataSecurity.isEmpty(dtoDoctor.getName())
                && !mUserDataSecurity.isEmpty(dtoDoctor.getSurname()) && !mUserDataSecurity.isEmpty(dtoDoctor.getSpecialization())
                && !mUserDataSecurity.isEmpty(dtoDoctor.getExperience()) && !mUserDataSecurity.isEmpty(dtoDoctor.getRegalies())
                && !mUserDataSecurity.isEmpty(dtoDoctor.getPhone()) && !mUserDataSecurity.isEmpty(dtoDoctor.getPatronymic())) {
            mDoctorService.addDoctor(dtoDoctor, cityId, hospitalId);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}/hospitals/{id_hospital}/doctors/{id_doctor}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDoctor(@RequestHeader(value = "ORIGIN") String origin,
                                       @PathVariable("id_city") int cityId,
                                       @PathVariable("id_hospital") int hospitalId,
                                       @PathVariable("id_doctor") int doctorId,
                                       @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token)) {
            mDoctorService.deleteDoctor(doctorId);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

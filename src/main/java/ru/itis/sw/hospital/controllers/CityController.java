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
public class CityController {

    @Autowired
    private HealthService mHealthService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities", method = RequestMethod.GET)
    public ResponseEntity<List<CityDto>> getCities(@RequestHeader(value = "ORIGIN") String origin){
        return new ResponseEntity<List<CityDto>>(mHealthService.getCities(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/city/{id_city}", method = RequestMethod.GET)
    public ResponseEntity<CityDto> getCity(@RequestHeader(value = "ORIGIN") String origin,
                                           @PathVariable("id_city") int cityId){
        return new ResponseEntity<CityDto>(mHealthService.getCity(cityId), HttpStatus.OK);
    }
}

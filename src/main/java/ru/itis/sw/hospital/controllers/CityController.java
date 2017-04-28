package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.repository.UserDataSecurity;
import ru.itis.sw.hospital.models.dto.*;
import ru.itis.sw.hospital.repository.CityService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CityController {

    @Autowired
    private CityService mCityService;

    @Autowired
    private UserDataSecurity mUserDataSecurity;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities", method = RequestMethod.GET)
    public ResponseEntity<List<CityDto>> getCities(@RequestHeader(value = "ORIGIN") String origin){
        return new ResponseEntity<List<CityDto>>(mCityService.getCities(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}", method = RequestMethod.GET)
    public ResponseEntity<CityDto> getCity(@RequestHeader(value = "ORIGIN") String origin,
                                           @PathVariable("id_city") int cityId){
        return new ResponseEntity<CityDto>(mCityService.getCity(cityId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities", method = RequestMethod.POST)
    public ResponseEntity addCity(@RequestHeader(value = "ORIGIN") String origin,
                                  @RequestBody CityDto dtoCity,
                                  @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token) && !mUserDataSecurity.isEmpty(dtoCity.getName())) {
            mCityService.addCity(dtoCity);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/health/cities/{id_city}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCity(@RequestHeader(value = "ORIGIN") String origin,
                                     @PathVariable("id_city") int cityId,
                                     @RequestParam("token") String token){
        if(mUserDataSecurity.verifyAdminToken(token)) {
            mCityService.deleteCity(cityId);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.dao.UserDataSecurity;
import ru.itis.sw.hospital.dao.models.TokenObject;
import ru.itis.sw.hospital.dao.models.dto.*;
import ru.itis.sw.hospital.service.HealthService;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private HealthService mHealthService;

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
}

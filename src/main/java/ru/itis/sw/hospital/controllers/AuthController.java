package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.models.TokenObject;
import ru.itis.sw.hospital.models.dto.*;
import ru.itis.sw.hospital.repository.AuthService;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService mAuthService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<TokenObject> auth(@RequestHeader(value = "ORIGIN") String origin,
                                            @RequestBody LoginInfoDto loginInfoDto){
        return new ResponseEntity<TokenObject>(mAuthService.auth(loginInfoDto), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestHeader(value = "ORIGIN") String origin,
                                   @RequestBody LoginInfoDto loginInfoDto){
        if(mAuthService.register(loginInfoDto))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

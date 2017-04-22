package ru.itis.sw.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.sw.hospital.service.ContactService;

@RestController
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactService mContactService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/contact/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hi(){
        return new ResponseEntity<String>(mContactService.hi(), HttpStatus.OK);
    }
}

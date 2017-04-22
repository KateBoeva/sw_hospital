package ru.itis.sw.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.sw.hospital.dao.ContactDao;

import java.util.List;

@Component
public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactDao mContactDao;

    @Override
    public String hi(){
        return "Hello";
    }
}

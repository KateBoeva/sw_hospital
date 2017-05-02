package ru.itis.sw.hospital.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AuthLoggingAspect {

    private static Logger log = Logger.getLogger(AuthLoggingAspect.class.getName());

    @After("execution(* ru.itis.sw.hospital.service.AuthServiceImpl.auth(..))")
    public void loggingCityServiceFuncGetAll(JoinPoint jp){
        log.info("auth");
    }

    @After("execution(* ru.itis.sw.hospital.service.AuthServiceImpl.register(..))")
    public void loggingCityServiceFuncAdd(JoinPoint jp){
        log.info("register");
    }
}

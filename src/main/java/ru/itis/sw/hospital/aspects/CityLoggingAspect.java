package ru.itis.sw.hospital.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CityLoggingAspect {

    private static Logger log = Logger.getLogger(CityLoggingAspect.class.getName());

    @Before("execution(* ru.itis.sw.hospital.service.CityServiceImpl.getCities(..))")
    public void loggingCityServiceFuncGetAll(JoinPoint jp){
        log.info("request cities");
    }

    @Before("execution(* ru.itis.sw.hospital.service.CityServiceImpl.getCity(..))")
    public void loggingCityServiceFuncGet(JoinPoint jp){
        log.info("request city");
    }

    @After("execution(* ru.itis.sw.hospital.service.CityServiceImpl.addCity(..))")
    public void loggingCityServiceFuncAdd(JoinPoint jp){
        log.info("return city");
    }

    @After("execution(* ru.itis.sw.hospital.service.CityServiceImpl.deleteCity(..))")
    public void loggingCityServiceFuncDelete(JoinPoint jp){
        log.info("delete city");
    }

}

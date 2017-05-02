package ru.itis.sw.hospital.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class TimetableLoggingAspect {

    private static Logger log = Logger.getLogger(TimetableLoggingAspect.class.getName());

    @After("execution(* ru.itis.sw.hospital.service.TimetableServiceImpl.changeTimetable(..))")
    public void loggingCityServiceFuncGetAll(JoinPoint jp){
        log.info("change timetable");
    }

    @Before("execution(* ru.itis.sw.hospital.service.TimetableServiceImpl.getTimetable(..))")
    public void loggingCityServiceFuncAdd(JoinPoint jp){
        log.info("return timetable");
    }
}

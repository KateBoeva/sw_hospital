package ru.itis.sw.hospital;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.sw.hospital.repository.AuthService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebAppContext.class);
        AuthService service = context.getBean(AuthService.class);
    }

}

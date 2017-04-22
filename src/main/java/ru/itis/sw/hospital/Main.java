package ru.itis.sw.hospital;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.sw.hospital.service.ContactService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebAppContext.class);
        ContactService service = context.getBean(ContactService.class);
    }

}

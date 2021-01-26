package com.spring.ioc.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.soap.SOAPBinding;

public class SpringApplication {
    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
//        ApplicationContext context=new AnnotationConfigApplicationContext("com.spring.ioc.aop");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        System.out.println(context.getBean(UserService.class));
        UserService userService=context.getBean(UserService.class);
        userService.save();
    }
}

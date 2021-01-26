//package com.spring.ioc.aop;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Service {
//    @Bean
//    public UserService userService(){
//        UserService userService=new UserService();
//        userService.setUserDao(userDao());
//        return userService;
//
//    }
//    @Bean
//    public UserDao userDao(){
//        return new UserDao();
//    }
//}

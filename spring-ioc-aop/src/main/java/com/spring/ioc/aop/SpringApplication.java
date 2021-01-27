package com.spring.ioc.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
//        ApplicationContext context=new AnnotationConfigApplicationContext("com.spring.ioc.aop");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
//        context.addApplicationListener(new ApplicationStartedListner());
        context.refresh();
        System.out.println(context.getBean(UserServiceImpl.class));
        UserServiceImpl userServiceImpl =context.getBean(UserServiceImpl.class);
        userServiceImpl.save();
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));

//        System.out.println(SingleToUser.getInstence());
//        System.out.println(SingleToUser.getInstence());
        System.out.println(userServiceImpl);
        System.out.println(context.getBean(UserServiceImpl.class));
    }
}

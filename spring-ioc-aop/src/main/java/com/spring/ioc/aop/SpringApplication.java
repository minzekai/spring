package com.spring.ioc.aop;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringApplication {
    public static void run(String[] args) throws LifecycleException {
//        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
//        ApplicationContext context=new AnnotationConfigApplicationContext("com.spring.ioc.aop");
//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//        context.register(AppConfig.class);
//        context.addApplicationListener(new ApplicationStartedListner());
//        context.refresh();
//        UserDao userDao =(UserDao) context.getBean(UserDao.class);
//        userDao.save();
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));

//        System.out.println(SingleToUser.getInstence());
//        System.out.println(SingleToUser.getInstence());
//        System.out.println(userServiceImpl);



        Tomcat tomcat=new Tomcat();
        Connector connector=new Connector();
        connector.setPort(80);
        tomcat.getService().addConnector(connector);

        StandardContext standardContext=new StandardContext();
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        standardContext.setPath("mvc");
        tomcat.getHost().addChild(standardContext);
        tomcat.start();

        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext=new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(SpringMvc.class);
//        annotationConfigWebApplicationContext.refresh();
        DispatcherServlet dispatcherServlet=new DispatcherServlet(annotationConfigWebApplicationContext);


        tomcat.addServlet("/mvc","dispatcherServlet",dispatcherServlet);
        standardContext.addServletMappingDecoded("/","dispatcherServlet");


        tomcat.getServer().await();
    }
}

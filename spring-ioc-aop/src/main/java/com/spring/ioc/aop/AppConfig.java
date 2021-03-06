package com.spring.ioc.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.CollectionUtils;

@Configuration
@EnableAspectJAutoProxy
//@Import({Service.class})
@ComponentScan("com.spring.ioc.aop")
public class AppConfig {
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

    /**
     * 事件监听器
     * @param event
     */
    @EventListener
    public void refreshListener(ContextRefreshedEvent event){
        System.out.println(event.getTimestamp());
        ApplicationContext context=event.getApplicationContext();
        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));

    }
}

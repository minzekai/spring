package com.spring;

import com.spring.ioc.aop.UserService;

import java.util.Date;

public class ProxyUserService implements UserService {

    private UserService userService;
    public ProxyUserService(UserService userService){
        this.userService=userService;
    }

    @Override
    public void save() {
        Date start=new Date();
        System.out.println("开始运行时间为"+start.toLocaleString());
        userService.save();
        Date end=new Date();
        System.out.println("结束运行时间为"+end.toLocaleString());
        System.out.println("运行时间为:"+(end.getTime()-start.getTime()));
    }
}

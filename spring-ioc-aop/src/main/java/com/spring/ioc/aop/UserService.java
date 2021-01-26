package com.spring.ioc.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;



    public void save(){
        System.out.println("UserService save");
        userDao.save();
    }
}

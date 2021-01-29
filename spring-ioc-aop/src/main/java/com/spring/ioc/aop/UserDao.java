package com.spring.ioc.aop;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Trascation(propagate = "this is a anns")
    public void save(){
        System.out.println("UserDao save");
    }
}

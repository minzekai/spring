package com.spring;

import com.spring.ioc.aop.UserDao;
import com.spring.ioc.aop.UserService;
import com.spring.ioc.aop.UserServiceImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class ProxyUserTest {

    @Test
    public void testProxyUserService(){
        ProxyUserService proxyUserService=new ProxyUserService(new UserServiceImpl());
        proxyUserService.save();
    }
    @Test
    public void ProxyJdk(){
        ProxyJDK proxyJDK=new ProxyJDK(new UserServiceImpl());
        UserService userService=(UserService) proxyJDK.getProxy();
        userService.save();
    }

    @Test
    public void CglibProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new CglibProxy());
        UserDao userDao=(UserDao) enhancer.create();
        userDao.save();
    }
}

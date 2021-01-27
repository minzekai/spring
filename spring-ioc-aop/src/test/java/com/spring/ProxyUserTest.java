package com.spring;

import com.spring.ioc.aop.UserService;
import com.spring.ioc.aop.UserServiceImpl;
import org.junit.Test;

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
}

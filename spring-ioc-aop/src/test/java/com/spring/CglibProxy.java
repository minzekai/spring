package com.spring;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Date start=new Date();
        System.out.println("开始运行时间为"+start.toLocaleString());
        methodProxy.invokeSuper(target,args);
        Date end=new Date();
        System.out.println("结束运行时间为"+end.toLocaleString());
        System.out.println("运行时间为:"+(end.getTime()-start.getTime()));
        return null;
    }
}

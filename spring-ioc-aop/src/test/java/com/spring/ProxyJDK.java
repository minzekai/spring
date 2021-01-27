package com.spring;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class ProxyJDK implements InvocationHandler {
    public Object target;

    public ProxyJDK(Object target){
        this.target=target;
    }

    public Object getProxy(){
        return  Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Date start=new Date();
        System.out.println("开始运行时间为"+start.toLocaleString());
        Object result=method.invoke(target,args);
        Date end=new Date();
        System.out.println("结束运行时间为"+end.toLocaleString());
        System.out.println("运行时间为:"+(end.getTime()-start.getTime()));
        return result;
    }
}

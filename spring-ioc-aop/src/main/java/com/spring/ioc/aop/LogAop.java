package com.spring.ioc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class LogAop {
//    @Pointcut("execution(public void com.spring.ioc.aop..*.*(..))")
//    @Pointcut("execution(public void com.spring.ioc.aop.UserServiceImpl.*(..))")
    @Pointcut("@annotation(com.spring.ioc.aop.Trascation)")
    public void pointcut(){

    }

//    @Around("pointcut()")
//    public void aroud(ProceedingJoinPoint joinPoint) throws Throwable {
//        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
//        Method method=methodSignature.getMethod();
//        Trascation trascation=method.getAnnotation(Trascation.class);
//        if(trascation!=null){
//            System.out.println(trascation.propagate());
//        }
//        System.out.println("日志开始运行");
//        joinPoint.proceed(joinPoint.getArgs());
//        System.out.println("日志结束运行");
//    }

    @Around("pointcut() && @annotation(trascation)")
    public void aroud(ProceedingJoinPoint joinPoint,Trascation trascation) throws Throwable {

        if(trascation!=null){
            System.out.println(trascation.propagate());
        }
        System.out.println("日志开始运行");
        joinPoint.proceed(joinPoint.getArgs());
        System.out.println("日志结束运行");
    }

}

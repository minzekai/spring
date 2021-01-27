package com.spring.ioc.aop;

public class SingleToUser {
    private SingleToUser(){

    }
    private static SingleToUser singleToUser;
    public static SingleToUser getInstence(){
        if(singleToUser==null){
            singleToUser=new SingleToUser();
            return singleToUser;
        }else{
            return singleToUser;
        }
    }
}

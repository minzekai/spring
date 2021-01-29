package com.spring.ioc.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hellotest(){
        return "this is a controller 测试";
    }

    @RequestMapping("/user")
    public User user(){
        User user=new User();
        user.setAddress("湖南省");
        user.setAge(20);
        user.setName("admin");
        return user;
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("E:\\repassword"));
        return "success";
    }


}

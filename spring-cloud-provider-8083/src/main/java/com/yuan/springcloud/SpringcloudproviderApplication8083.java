package com.yuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * spring boot应用的入口
 */
//@EnableSwagger2 //开启swagger
@SpringBootApplication
@EnableEurekaClient //开启eureka的客户端
public class SpringcloudproviderApplication8083 {

    public static void main(String args[])throws  Exception{
        SpringApplication.run(SpringcloudproviderApplication8083.class,args);
    }

}

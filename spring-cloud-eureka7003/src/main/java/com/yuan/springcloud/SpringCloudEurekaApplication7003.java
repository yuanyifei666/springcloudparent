package com.yuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启eureka服务
public class SpringCloudEurekaApplication7003 {

    public static  void main(String args[]){
        SpringApplication.run(SpringCloudEurekaApplication7003.class,args);
    }

}

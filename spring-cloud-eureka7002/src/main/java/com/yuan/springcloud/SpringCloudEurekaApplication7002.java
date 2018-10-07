package com.yuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启eureka的服务
public class SpringCloudEurekaApplication7002 {

    public static void main(String args[])throws Exception{
        SpringApplication.run(SpringCloudEurekaApplication7002.class,args);
    }
}

package com.yuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //开启config的服务
public class SpringCloudConfig4403 {

    public static void main(String args[])throws Exception{
        SpringApplication.run(SpringCloudConfig4403.class,args);
    }
}

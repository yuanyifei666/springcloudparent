package com.yuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
/**
 * department消费者的入口程序
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient //开启eureka的客户端
@EnableFeignClients //开启Feign webservice客户端
//@EnableHystrix
public class SpringCloudConsumerHystrixApplication {

    public static void main(String args[])throws Exception{
        //启动springboot项目
        SpringApplication.run(SpringCloudConsumerHystrixApplication.class,args);
    }

}

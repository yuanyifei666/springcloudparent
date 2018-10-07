package com.yuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启zuul路由网关的功能(作用：请求的过滤和代理)
public class SpringCloudZuul {
//throws Exception
    public static void main(String args[]){
        SpringApplication.run(SpringCloudZuul.class,args);
//        System.out.print("");
    }

}

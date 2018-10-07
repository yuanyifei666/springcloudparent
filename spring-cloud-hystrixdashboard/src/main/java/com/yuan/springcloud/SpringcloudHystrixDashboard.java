package com.yuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * HystrixDashBoard
 */
@SpringBootApplication
@EnableHystrixDashboard //开启HystrixDashboard监控功能
public class SpringcloudHystrixDashboard {

    public static void main(String args[])throws Exception{
        SpringApplication.run(SpringcloudHystrixDashboard.class,args);
    }

}

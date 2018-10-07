package com.yuan.springcloud;

import com.yuan.ruleConfig.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * department消费者的入口程序
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient //开启eureka的客户端
@RibbonClient(name = "SPRING-CLOUD-PROVIDER" , configuration = MyRuleConfig.class) //使用自定义的ribbon的负载均衡规则
public class SpringCloudConsumerApplication {

    public static void main(String args[])throws Exception{
        //启动springboot项目
        SpringApplication.run(SpringCloudConsumerApplication.class,args);
    }

}

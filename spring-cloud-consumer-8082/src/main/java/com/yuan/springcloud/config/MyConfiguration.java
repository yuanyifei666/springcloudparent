package com.yuan.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者的配置类
 */
@Configuration
public class MyConfiguration {

    /**
     * 使用RestTemplate类来访问RESTFUL风格的http地址
     */
    @Bean
    @LoadBalanced //使用Ribbon的客户端负载均衡工具
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 修改默认的负载均衡算法
     *
     */
//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }

}

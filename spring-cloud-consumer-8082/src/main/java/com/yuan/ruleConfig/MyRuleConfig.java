package com.yuan.ruleConfig;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的负载均衡规则
 */
@Configuration
public class MyRuleConfig {

    /**
     * 使用自定义的负载均衡规则
     */
    @Bean
    public IRule myIRule(){
        return new MyRandomRule();
    }

}

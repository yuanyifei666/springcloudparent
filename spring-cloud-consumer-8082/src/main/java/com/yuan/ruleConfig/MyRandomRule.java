package com.yuan.ruleConfig;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 自定义负载均衡的规则: 每个服务调用5次
 */
public class MyRandomRule extends AbstractLoadBalancerRule {

    private int count = 0;//用于标记是否调用了五次
    private int currentIndex = 0; //用于调用哪个服务

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers(); //得到健康的服务
            List<Server> allList = lb.getAllServers();//得到所有的服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            System.out.println("count---->"+count+"currentIndex----->"+currentIndex);
            System.out.println("upList---->"+upList);
            //自定义负载均衡的规则 : 每个服务各调用5次
            if (count < 5){
                server = upList.get(currentIndex);
                count ++;
            }else
            {
                //如果大于5则调用下一个服务
                currentIndex++;
                if (currentIndex >= allList.size()){
                    currentIndex = 0;
                }
                server = upList.get(currentIndex);
                count = 0;
            }


//
//            int index = chooseRandomInt(serverCount);
//
//            server = upList.get(index);
            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield(); //停止当前正在运行的线程
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}

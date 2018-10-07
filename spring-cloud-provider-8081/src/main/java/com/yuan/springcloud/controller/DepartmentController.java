package com.yuan.springcloud.controller;

import com.yuan.springcloud.service.DepartmentService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * 操作department表的department
 */
@RestController
@RequestMapping("/department/provider")
//@Api(value = "操作department表的Controller")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询department表中的所有数据
     */
//    @ApiOperation(value = "查询department表中的所有数据",notes="查询department表中的所有信息，并返回list集合" )
    @GetMapping("/findAll")
    public List findAll()throws Exception{
        System.out.println("Spring-cloud-provider-8081-----------------");
       return departmentService.findAll();
    }

    /**
     *根据id删除department表中的一条数据
     *
     */
//    @ApiOperation(value="根据id删除数据",notes = "根据department的id删除数据")
//    @ApiImplicitParam(name="id",value = "要删除的department表中的id")
    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable(name = "id") Integer id)throws Exception{
        departmentService.delete(id);
    }

    @Autowired
    private DiscoveryClient client;//发现服务

    @RequestMapping("/department/discovery")
    public List discovery(){
        List<String> services = client.getServices();//得到所有的服务
        System.out.println("services--->"+services);
        //得到具体某个服务的具体信息
        List<ServiceInstance> instances = client.getInstances("SPRING-CLOUD-PROVIDER-8081");
        for (ServiceInstance service:instances) {
            String serviceId = service.getServiceId();
            String host = service.getHost();
            URI uri = service.getUri();
            System.out.println("serviceId["+serviceId+"],host["+host+"],uri["+uri+"]");
        }
        return instances;
    }

}

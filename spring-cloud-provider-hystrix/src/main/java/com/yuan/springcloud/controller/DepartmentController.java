package com.yuan.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yuan.springcloud.entity.Department;
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
//        if(count%2==0){
//            throw new RuntimeException("自定义运行时异常。。。。。。");
//        }
//        count ++;
         return departmentService.findAll();
    }

    /**
     * 根据id查询department表中的数据
     */
    @GetMapping("/findById/{id}")
    @HystrixCommand(fallbackMethod = "FALLBACK_GET") //开启熔断器的监控
    public Department findById(@PathVariable(name = "id") Integer id)throws  Exception{
        Department result = departmentService.findById(id);
        if (result == null){
            throw new RuntimeException("该数据不存在!");
        }
        return result;
    }
//    @GetMapping("/findById/{id}")
    public Department FALLBACK_GET(@PathVariable(name = "id") Integer id){
        return new Department(id,"该id的数据不存在!","this data not in cloud database");
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

}

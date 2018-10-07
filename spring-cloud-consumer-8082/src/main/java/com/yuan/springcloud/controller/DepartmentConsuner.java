package com.yuan.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Department的消费者
 */
@RestController
@RequestMapping("department/consumer")
public class DepartmentConsuner {

//    private static final String REST_DEPARTMENT_URL = "http://localhost:8081/department/provider/";
    private static final String REST_DEPARTMENT_URL = "http://SPRING-CLOUD-PROVIDER/department/provider/";


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用提供者，得到department的所有数据
     */
    @GetMapping("/departments")
    public List departments()throws Exception{
        return restTemplate.getForObject(REST_DEPARTMENT_URL+"findAll",List.class);
    }


}

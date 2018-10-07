package com.yuan.springcloud.controller;

import com.yuan.springcloud.entity.Department;
import com.yuan.springcloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private DepartmentService departmentService;
    /**
     * 调用提供者，得到department的所有数据
     */
    @GetMapping("/departments")
    public List departments()throws Exception{
        return departmentService.findAll();
    }

    /**
     * 根据department的id查询数据库
     */
    @GetMapping("/department/{id}")
    public Department department(@PathVariable(name = "id") Integer id)throws Exception{
        return departmentService.findById(id);
    }

}

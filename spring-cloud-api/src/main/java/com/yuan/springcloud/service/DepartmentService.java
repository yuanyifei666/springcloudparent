package com.yuan.springcloud.service;

import com.yuan.springcloud.entity.Department;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * departmen业务的api
 * 使用Feign
 */
//@FeignClient(name = "SPRING-CLOUD-PROVIDER")
@FeignClient(name = "SPRING-CLOUD-PROVIDER",fallbackFactory = DepartmentServiceFallbackFactory.class)
public interface DepartmentService {

    /** 向Department表中插入一条数据**/

//    public void insert(Department department)throws Exception;

    /** 根据id删除一条数据**/
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Integer id)throws Exception;

    /** 更新一条数据**/
//    public void update(Department department)throws Exception;

    /** 根据id查询数据**/
//    @RequestMapping(value="")
//    public Department findById(Integer id)throws Exception;

    /** 查询department表中的所有的数据**/
    @RequestMapping(value = "/department/provider/findAll",method = RequestMethod.GET)
//    @GetMapping(value = "/department/provider/findAll")
    public List<Department> findAll()throws Exception;

    /** 根据department的id查询数据**/
    @RequestMapping(name = "/department/provider/findById/{id}",method = RequestMethod.GET)
    public Department findById(@PathVariable(name = "id")Integer id)throws Exception;
}

package com.yuan.springcloud.service;

import com.yuan.springcloud.entity.Department;

import java.util.List;

/**
 * departmen业务的api
 */
public interface DepartmentService {

    /** 向Department表中插入一条数据**/
    public void insert(Department department)throws Exception;

    /** 根据id删除一条数据**/
    public void delete(Integer id)throws Exception;

    /** 更新一条数据**/
    public void update(Department department)throws Exception;

    /** 根据id查询数据**/
    public Department findById(Integer id)throws Exception;

    /** 查询department表中的所有的数据**/
    public List<Department> findAll()throws Exception;

}

package com.yuan.springcloud.service.impl;

import com.yuan.springcloud.en.ResultEnum;
import com.yuan.springcloud.entity.Department;
import com.yuan.springcloud.exception.MyException;
import com.yuan.springcloud.mapper.DepartmentMapper;
import com.yuan.springcloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * department业务的具体实现
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /** 向Department表中插入一条数据**/
    public void insert(Department department) throws Exception {
        //验证传入的数据是否合法
        if (department == null){
           //抛出自定义异常
            throw new MyException(ResultEnum.RESULT_SERVICE_DEPARTMENT_NOTNULL.getMessage());
        }
        //不为空则向department表中插入数据
        departmentMapper.insert(department);
    }

    /** 根据id删除一条数据**/
    public void delete(Integer id) throws Exception {
        departmentMapper.delete(id);

    }

    /** 更新一条数据**/
    public void update(Department department) throws Exception {
        departmentMapper.update(department);
    }

    /** 根据id查询数据**/
    public Department findById(Integer id) throws Exception {
        return departmentMapper.findById(id);

    }

    /** 查询department表中的所有的数据**/
    public List<Department> findAll() throws Exception {
        return departmentMapper.findAll();
    }
}

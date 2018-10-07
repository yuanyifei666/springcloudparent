package com.yuan.springcloud.service;

import com.yuan.springcloud.entity.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FallbackFactory自定义fallback信息
 */
@Component
public class DepartmentServiceFallbackFactory implements FallbackFactory<DepartmentService> {
    @Override
    public DepartmentService create(Throwable throwable) {
        return new DepartmentService() {
            @Override
            public void delete(Integer id) throws Exception {
                //当客户端调用delete服务失败则返回自定义的fallback信息

            }

            @Override
            public List<Department> findAll() throws Exception {
                //当客户端调用findAll服务失败则返回自定义的fallback信息
                return Arrays.asList(new Department(400,"该服务正在维护中，暂停服务.................","sorry this service is shutdown"));
            }

            @Override
            public Department findById(Integer id) throws Exception {
                return null;
            }
        };
    }
}

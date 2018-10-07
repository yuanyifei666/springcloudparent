package com.yuan.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * department表对应的实体类
 */

@Data//生成set和get方法
@NoArgsConstructor//生产无惨的构造方法
@AllArgsConstructor//生产全部属性的构造方法
public class Department implements Serializable {

    private Integer deptno;
    private String dname;
    private String dbSource;


}

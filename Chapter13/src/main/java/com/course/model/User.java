package com.course.model;

import lombok.Data;

/**
 * @author wb-fyx220651
 * @date 2018/10/3
 */
@Data
public class User {
    /**定义变量*/
    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    /**定义变量：权限*/
    private String permission;
    /**isDelete：表示数据是否删除*/
    private String isDelete;
}

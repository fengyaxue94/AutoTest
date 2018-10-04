package com.course.model;

import lombok.Data;

/**
 * @author wb-fyx220651
 * @date 2018/9/29
 */
@Data
public class User {

    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    /**定义变量：权限*/
    private String permission;
    /**isDelete：表示数据是否删除*/
    private String isDelete;
    /**json数据的处理*/
    @Override
    /**按照json数据格式进行拼接处理*/
    public String toString(){
        return(
            "{id:"+id+","+
             "userName:"+userName+","+
             "password:"+password+","+
             "age:"+age+","+
             "sex:"+sex+","+
             "permission:"+permission+","+
             "isDelete:"+isDelete+"}"
            );
    }
}

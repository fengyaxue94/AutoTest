package com.course.model;

import lombok.Data;

/**
 * @author wb-fyx220651
 * @date 2018/9/29
 * 更新、删除用户
 */
@Data
public class UpdateUserInfoCase {

    private int id;
    private int userId;
    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    /**expected：预期结果*/
    private String expected;

}

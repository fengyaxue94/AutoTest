package com.course.model;

import lombok.Data;

/**
 * @author wb-fyx220651
 * @date 2018/9/29
 * 获取用户列表
 */
@Data
public class GetUserListCase {
    private String userName;
    private String age;
    private String sex;
    /**expected：预期结果*/
    private String expected;

    public String getExpected() {
        return expected;
    }

    public String getUserName() {
        return userName;
    }
    public String getSex() {
        return sex;
    }
    public String getAge() {
        return age;
    }

}
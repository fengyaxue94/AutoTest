package com.course.model;

import lombok.Data;

/**
 * @author wb-fyx220651
 * @date 2018/9/29
 */
@Data
public class LoginCase {
    private int id;
    private String userName;
    private String password;
    /**expected：预期结果*/
    private String expected;
}


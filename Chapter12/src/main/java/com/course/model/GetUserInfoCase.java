package com.course.model;

import lombok.Data;

/**
 * @author wb-fyx220651
 * @date 2018/9/29
 * 获取用户信息
 */
@Data
public class GetUserInfoCase {
    private int userId;
    /**expected：预期结果*/
    private String expected;
}

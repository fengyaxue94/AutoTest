package com.course.config;

import lombok.Data;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
/**
 * @author wb-fyx220651
 * @date 2018/9/29
 */
@Data
/**装一些变量，变量是application中对应的*/
public class TestConfig {
    /**登陆接口uri，使用静态变量原因：加载一次就行了
     * 要和配置文件中的名称相对应
     */
    public static String loginUrl;
    /**更新用户信息接口uri*/
    public static String updateUserInfoUrl;
    /**获取用户列表接口uri*/
    public static String getUserListUrl;
    /**获取用户信息接口uri*/
    public static String getUserInfoUrl;
    /**添加用户信息接口uri*/
    public static String addUserUrl;

    /**声明http客户端(定义httpclient)*/
    public static DefaultHttpClient defaultHttpClient;
    /**用来存储cookies信息的变量*/
    public static CookieStore store;

}


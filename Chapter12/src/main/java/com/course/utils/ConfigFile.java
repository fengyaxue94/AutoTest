package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author wb-fyx220651
 * @date 2018/9/29
 */
public class ConfigFile {

    private static ResourceBundle bundle= ResourceBundle.getBundle("application", Locale.CHINA);
    /**拼接url地址
     * 工具类拼接url
     * 工具类方法命名为静态方法，不用new，可以直接使用
     */
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        /**最终拼接好的测试地址*/
        String testUrl;
        if(name == InterfaceName.GETUSERLIST){
            uri = bundle.getString("getUserList.uri");

        }

        if(name == InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }

        if(name == InterfaceName.UPDATEUSERINFO){
            uri = bundle.getString("updateUserInfo.uri");
        }

        if(name == InterfaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }

        if(name == InterfaceName.ADDUSERINFO){
            uri = bundle.getString("addUser.uri");
        }
        testUrl = address + uri;
        /**返回最终拼接好的测试地址*/
        return testUrl;
    }
}

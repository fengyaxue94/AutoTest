package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author wb-fyx220651
 * @date 2018/10/2
 */
public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取HttpClient对象")
    /**正式测试之前执行的一些方法*/
    public void beforeTest(){
        /**new一个httpclient对象
         * cookie调用一个接口后再赋值，登录成功之后再赋值，赋值是为了之后的接口在应用的时候不用再登录了
         */
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.loginUrl =  ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
    }
    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        /**取第1条数据*/
        LoginCase loginCase = session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        /**第1步就是发送请求*/
        String result = getResult(loginCase);
        /**验证结果*/
        Assert.assertEquals(loginCase.getExpected(),result);


    }

    private String getResult(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());

        /**设置头信息*/
        post.setHeader("content-type","application/json");
        /**将参数信息添加到方法中*/
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        /**设置cookies*/
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        /**声明一个对象来进行响应结果的存储，存放返回结果*/
        String result;
        /**执行post方法*/
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        /**获取响应结果*/
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        return result;
    }

    @Test(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        /**取第2条数据*/
        LoginCase loginCase = session.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        /**第1步就是发送请求*/
        String result = getResult(loginCase);
        /**验证结果*/
        Assert.assertEquals(loginCase.getExpected(),result);

    }
}

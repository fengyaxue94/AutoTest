package com.course.httpclient.cookies;

import netscape.javascript.JSObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author wb-fyx220651
 * @date 2018/9/24
 */
public class MyCookiesForPost{
    private String url;
    private ResourceBundle bundle;
    /**用来存储cookies信息的变量,private:私有变量，只在这个类里边进行使用*/
    private CookieStore store;
    @BeforeTest
    /**在测试方法执行之前，把配置文件加载出来*/
    public void beforeTest(){
        /*给bundle赋值，ResourceBundle对象默认识别properties文件，所以不用加后缀，只写application就行**/
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        /**给url赋值*/
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        /**从配置文件中，拼接测试的url*/
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url+uri;
        /**测试逻辑代码书写*/
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        /**获取cookies信息，因为cookie可以有很多信息所以用list保存*/
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+ name +"; cookie value = " + value);
        }
    }
    /**依赖关系，依赖上面的case执行*/
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        /**拼接最终的测试地址*/
        String testurl = this.url + uri;
        /**声明一个client对象，用来进行方法的执行*/
        DefaultHttpClient client = new DefaultHttpClient();
        /**声明一个方法，这个方法就是post方法*/
        HttpPost post  = new HttpPost(testurl);
        /**添加参数*/
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        /**设置请求头信息*/
        post.setHeader("content-type","application/json");
        /**将参数信息添加到方法中*/
        StringEntity entity  = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        /**声控一个对象来进行响应结果的存储*/
        String result;
        /**设置cookies信息*/
        client.setCookieStore(this.store);
        /**执行post方法*/
        HttpResponse response = client.execute(post);
        /**获取响应结果*/
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        /**处理结果，就是判断返回结果是否符合预期*/
        /**将返回的响应结果字符串转化为json对象*/
        JSONObject resultJson = new JSONObject(result);
        /**获取到结果值*/
        String success = (String)resultJson.get("huhansan");
        String status = (String)resultJson.get("status");
        /**具体的判断返回结果的值*/
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);


    }
}

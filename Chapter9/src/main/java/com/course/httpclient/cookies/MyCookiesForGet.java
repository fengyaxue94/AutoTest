package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpClientConnectionOperator;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author wb-fyx220651
 * @date 2018/9/24
 */
public class MyCookiesForGet {
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
    public void  testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testurl = this.url+uri;
        /**声明一个客户端*/
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        /**设置cookies信息*/
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        /**获取响应的状态码*/
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = " + statusCode);
        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
}

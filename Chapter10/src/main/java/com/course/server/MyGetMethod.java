package com.course.server;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wb-fyx220651
 * @date 2018/9/25
 */
@RestController
public class MyGetMethod{
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        /**HttpServerletRequest  装请求信息的类
         * HttpServerletResponse  装响应信息的类
         */
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }
    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        /**一般判断对象为空的小技巧*/
        if(Objects.isNull(cookies)){
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("login")&&
                cookie.getValue().equals("true")){
                return "这是一个需要携带cookies信息才能访问的get请求！";
            }
        }
        return "你必须携带cookies信息来";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求（get请求2种实现方式）
     * 第1种实现方式    url: key = value & key = value
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end) {
        Map<String, Integer> myList = new HashMap<>();
        /**添加商品信息，商品名称+价格*/
        myList.put("鞋", 400);
        myList.put("小浣熊干脆面", 1);
        myList.put("衬衫", 300);
        return myList;
    }

    /**
     * 开发一个需要携带参数才能访问的get请求（get请求2种实现方式）
     * 第二种需要携带参数访问的get请求
     * 第2种实现方式    url:ip:port/get/with/param/10/20
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    public Map myGetList(@PathVariable Integer start,
                                          @PathVariable Integer end) {
        Map<String, Integer> myList = new HashMap<>();
        /**添加商品信息，商品名称+价格*/
        myList.put("鞋", 400);
        myList.put("小浣熊干脆面", 1);
        myList.put("衬衫", 300);
        return myList;
    }

}

package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wb-fyx220651
 * @date 2018/9/26
 */
@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/v1")
public class MyPostMethod {

    /**这个变量是用来装我们cookies信息的*/
    private static Cookie cookie;
    /**用户登录成功获取到cookies，然后再访问其他接口获取到列表*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口,成功后获取cookies信息",httpMethod = "post")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username",required = true) String username,
                        @RequestParam(value = "password",required = true) String password){
        if (username.equals("zhangsan")&&password.equals("123456")){
            cookie = new Cookie("login","true");
            return "恭喜你登录成功了！";
        }
        return "用户名或者是密码错误！";
    }
    /**验证cookies，并且验证通过后，返回用户列表*/
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "post")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){
        User user;
        /**获取cookies*/
        Cookie[] cookies = request.getCookies();
        /**验证cookies是否合法*/
        for(Cookie c : cookies){
            String login = "login";
            String value = "true";
            String users = "zhangsan";
            String pwd = "123456";
            if(login.equals(c.getName())&& value.equals(c.getValue())
                && users.equals(u.getUserName()) && pwd.equals(u.getPassword())){
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}

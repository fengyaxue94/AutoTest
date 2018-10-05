package com.course.cases;

import com.course.config.TestConfig;
import com.course.utils.DatabaseUtil;
import com.course.model.AddUserCase;
import com.course.model.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author wb-fyx220651
 * @date 2018/10/2
 */
public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口测试")
    public void addUser() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = sqlSession.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);

        /**发请求，获取结果*/
        String result = getResult(addUserCase);
        /**验证返回结果*/
        /**User表中的数据*/
        Thread.sleep(3000);
        User user = sqlSession.selectOne("addUser",addUserCase);
        System.out.println(user.toString());
        /**结果判断*/
        Assert.assertEquals(addUserCase,result);
    }

    private String getResult(AddUserCase addUserCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
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

}

package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;


/**
 * @author wb-fyx220651
 * @date 2018/10/2
 */
public class DatabaseUtil {

    public static SqlSession getSqlSession() throws IOException {
        /**获取配置的资源文件*/
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        /**返回sqlsession*/
        /**sqlSession就是能够执行配置文件中的sql语句*/
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }
}

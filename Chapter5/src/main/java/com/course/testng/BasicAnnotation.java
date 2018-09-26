package com.course.testng;

import org.testng.annotations.*;

/**
 * @author wb-fyx220651
 * @date 2018/9/18
 */
public class BasicAnnotation {
    /**Test标签：最基本的注解，标识着一个测试的方法，用来把方法标记为测试的一部分*/
    @Test
    public void testcase1(){
        System.out.printf("Thread Id ：%s%n",Thread.currentThread().getId());
        System.out.println("Test这是测试用例1");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }
    @Test
    public void testCase2(){
        System.out.printf("Thread Id ：%s%n",Thread.currentThread().getId());
        System.out.println("Test这是测试用例2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod这是在测试方法之后运行的");
    }
    /**类运行之前之后执行的代码*/
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是在类运行之前运行的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类运行之后运行的方法");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }
}

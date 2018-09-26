package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * @author wb-fyx220651
 * @date 2018/9/20
 */
public class MultiThreadOnXml {
    @Test
    public void test1(){
        System.out.println(1);
        System.out.printf("Thread Id ：%s%n",Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.println(1);
        System.out.printf("Thread Id ：%s%n",Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.println(1);
        System.out.printf("Thread Id ：%s%n",Thread.currentThread().getId());
    }
}

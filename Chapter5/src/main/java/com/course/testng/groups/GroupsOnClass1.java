package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author wb-fyx220651
 * @date 2018/9/20
 */
@Test(groups = "stu")
public class GroupsOnClass1{
    public void stu1(){
        System.out.println("GroupsOnClass1中的stu111111运行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass1中的stu222222运行");
    }
}

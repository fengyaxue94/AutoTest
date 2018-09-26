package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author wb-fyx220651
 * @date 2018/9/20
 */
@Test(groups = "stu")
public class GroupsOnClass2{
    public void stu1(){
        System.out.println("GroupsOnClass222222中的stu1运行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass222222中的stu2运行");
    }

}

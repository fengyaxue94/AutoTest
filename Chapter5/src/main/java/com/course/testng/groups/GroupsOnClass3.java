package com.course.testng.groups;
import org.testng.annotations.Test;

/**
 * @author wb-fyx220651
 * @date 2018/9/20
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("GroupsOnClass3中的teacher111111运行");
    }
    public void teacher2(){
        System.out.println("GroupsOnClass3中的teacher222222运行");
    }
}

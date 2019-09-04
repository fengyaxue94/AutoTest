package com.course.testng;

import org.testng.annotations.Test;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
public class TestMqmessage {
    @Test
    public void  testMqProducer() throws Exception{
        /**初始化一个producer*/
        DefaultMQProducer producer = new DefaultMQProducer();
    }
}

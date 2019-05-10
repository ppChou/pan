package com.lhx.service;

import com.lhx.util.ConnectionUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class MqServer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Channel channel = ConnectionUtil.initConnetion();
        for (int i = 0; i < 100; i++) {
            String message = UUID.randomUUID().toString();
            channel.basicPublish("", ConnectionUtil.QUEUE_NAME, null, message.getBytes("UTF-8"));
            //定時發送消息  展示結果更加明顯
            Thread.sleep(1000);
        }
    }
}

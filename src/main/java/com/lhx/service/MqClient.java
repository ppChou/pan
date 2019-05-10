package com.lhx.service;

import com.lhx.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MqClient {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = ConnectionUtil.initConnetion();
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };
        channel.basicConsume( ConnectionUtil.QUEUE_NAME, true, consumer);
    }
}

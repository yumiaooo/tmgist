package com.creditease.tradematch.tmfront.gist.mock;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 */
public class Receive2 {
    private static Logger logger = LoggerFactory.getLogger(Receive2.class);

    public static void main(String[] argv) throws IOException, TimeoutException {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection conn = factory.newConnection(Executors.newFixedThreadPool(5));

        logger.info("is main? {}");

        final Channel channel = conn.createChannel();
        channel.basicQos(1);
        Consumer consumer1 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                logger.info("consumer1: {}, {}", consumerTag, new String(body));
                if ("3".equals(new String(body))) {
                    try {
                        TimeUnit.SECONDS.sleep(20);
                        logger.info("end sleep");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        Consumer consumer2 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                logger.info("consumer2: {}, {}", consumerTag, new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume(Send.q, false, consumer1);
        channel.basicConsume(Send.q, false, consumer2);


    }
}

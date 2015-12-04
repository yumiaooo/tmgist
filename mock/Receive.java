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
public class Receive {
    private static Logger logger = LoggerFactory.getLogger(Receive.class);

    public static void main(String[] argv) throws IOException, TimeoutException {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection conn = factory.newConnection(Executors.newFixedThreadPool(5));

        logger.info("is main? {}");

        final Channel channel1 = conn.createChannel();
        channel1.basicQos(1);
        Consumer consumer1 = new DefaultConsumer(channel1) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                logger.info("consumer1: {}, {}", consumerTag, new String(body));
                if ("3".equals(new String(body))) {
                    try {
                        TimeUnit.SECONDS.sleep(7);
                        logger.info("end sleep");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                channel1.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel1.basicConsume(Send.q, false, consumer1);

        final Channel channel2 = conn.createChannel();
        channel2.basicQos(1);
        Consumer consumer2 = new DefaultConsumer(channel2) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                logger.info("consumer2: {}, {}", consumerTag, new String(body));
                channel2.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel2.basicConsume(Send.q, false, consumer2);


    }
}

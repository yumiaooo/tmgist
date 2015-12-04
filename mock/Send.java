package com.creditease.tradematch.tmfront.gist.mock;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessagePropertiesBuilder;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 *
 */
public class Send {
    private static Logger logger = LoggerFactory.getLogger(Send.class);

    public static String q = "tset.gist";

    public static void main(String[] argv) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
//        factory.setPort(5673);
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
//        channel.queueDeclare("tset.gist", true, false, false, null);

        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .contentType("text/x-json")
                .deliveryMode(2)
                .build();
        Random random = new Random();
        String r = String.valueOf(random.nextInt());

        for (int i = 1; i <= 100; i++) {
            String msg = String.valueOf(i);
            channel.basicPublish("", q, props, (msg+" ("+r+")").getBytes());
        }

        logger.info("√");
        conn.close();
    }
}

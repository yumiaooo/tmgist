package com.creditease.tradematch.tmfront.gist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 *
 */
@Component("sintGist")
public class SpringIntegrationGist {
    private static Logger logger = LoggerFactory.getLogger(SpringIntegrationGist.class);

    boolean sleep = true;

    public void doBiz(String payload, @Header(value = "amqp_consumerTag") String consumerTag) throws InterruptedException {
        logger.info("{}, {}", consumerTag, payload);
        if ("2".equals(payload.substring(0,1)) && sleep) {
            sleep = false;
            TimeUnit.SECONDS.sleep(60);
            logger.info("end sleep");
        }
    }
}

package com.creditease.tradematch.tmfront.gist;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class TestMainClass {
    public static void main(String[] argv) {
//        System.setProperty("spring.profiles.default", "development");

        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "classpath:/gist/applicationContext-gist.xml");
        //"classpath:/applicationContext-propertyPlaceholder.xml"

    }
}

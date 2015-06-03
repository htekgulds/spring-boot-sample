package com.htds.spring.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * Created by Hasan
 * on 3.6.2015.
 */

@SpringApplicationConfiguration
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext ctx =SpringApplication.run(Application.class, args);
    }
}

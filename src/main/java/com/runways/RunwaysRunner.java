package com.runways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Application runner
 * @author oalizada
 */
@SpringBootApplication

@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class RunwaysRunner {
    public static void main(String[] args) throws Exception {

        SpringApplication.run(RunwaysRunner.class, args);
    }


}
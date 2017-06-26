package com.application.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by jonas on 2017-06-12.
 */

@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {

    public static void main (String[] args) {
        SpringApplication.run( Application.class, args );
    }

}

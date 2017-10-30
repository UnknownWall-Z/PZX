package com.memory.pzp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by wall on 2017/9/11.
 */

@SpringBootApplication
@Import(CoreConfig.class)
@PropertySource("classpath:application-website.properties")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }


}

package com.memory.pzp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by wall on 2017/9/12.
 */
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
@PropertySource("classpath:application-core.properties")
@MapperScan(basePackages="com.memory.pzp.*.mapper")
public class CoreConfig {
}

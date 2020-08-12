package com.shardingsphere.shardingsphere_demo_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties
public class ShardingsphereDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereDemo1Application.class, args);
    }

}

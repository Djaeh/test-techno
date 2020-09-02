package com.example.demo;

import com.example.demo.entity.TenantContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@SpringBootApplication
public class DemoApplication {

    @Bean
    Supplier<Object> tenant() {
        return TenantContext::getCurrentTenant;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

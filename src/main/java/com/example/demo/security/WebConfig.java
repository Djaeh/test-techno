package com.example.demo.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<TenantFilter> tenantFilter() {
        FilterRegistrationBean<TenantFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new TenantFilter());
        filter.addUrlPatterns("/*");
        filter.setName("TenantFilter");
        return filter;
    }
}

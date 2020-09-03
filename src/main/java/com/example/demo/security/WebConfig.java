package com.example.demo.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    //The filter should be disable for technical enpoint
    public FilterRegistrationBean<TenantFilter> tenantFilter() {
        FilterRegistrationBean<TenantFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new TenantFilter());
        filter.addUrlPatterns("/api/*");
        filter.setName("TenantFilter");
        return filter;
    }
}

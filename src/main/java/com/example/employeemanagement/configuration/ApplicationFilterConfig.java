package com.example.employeemanagement.configuration;

import com.example.employeemanagement.filter.EmployeeRequestResponseFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class ApplicationFilterConfig {

    private static final String URL_PATTERN = "/api/v1/emp/*";

    @Bean
    public FilterRegistrationBean<EmployeeRequestResponseFilter> employeeReqResFilterRegistrationBean() {
        FilterRegistrationBean<EmployeeRequestResponseFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new EmployeeRequestResponseFilter());
        registration.addUrlPatterns(URL_PATTERN);
        registration.setName("employeeRequestResponseFilter");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }
}

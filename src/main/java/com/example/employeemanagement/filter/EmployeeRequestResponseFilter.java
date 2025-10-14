package com.example.employeemanagement.filter;

import com.example.employeemanagement.util.ApplicationHeadersUtils;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StopWatch;

import java.io.IOException;

@Log4j2
public class EmployeeRequestResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String corrId = ApplicationHeadersUtils.ensureCorrelationId(httpServletRequest);
        httpServletResponse.setHeader(ApplicationHeadersUtils.CORRELATION_ID, corrId);

        log.info("correlationId={}", corrId);

        filterChain.doFilter(servletRequest, servletResponse);

        stopWatch.stop();
        long duration = stopWatch.getTotalTimeMillis();

        log.info("Request to {} took {} ms", httpServletRequest.getRequestURI(), duration);

    }
}

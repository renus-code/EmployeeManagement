package com.example.employeemanagement.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

import java.util.UUID;


public final class ApplicationHeadersUtils {

    public static final String CORRELATION_ID = "X-Correlation-Id";

    private ApplicationHeadersUtils() {
    }

    public static String ensureCorrelationId(HttpServletRequest request) {
        return ensureHeaderOrAttribute(request);
    }

    private static String ensureHeaderOrAttribute(HttpServletRequest request) {
        String value = request.getHeader(ApplicationHeadersUtils.CORRELATION_ID);

        if (StringUtils.hasLength(value)) {
            return value;
        }

        // Then, check if it's stored as a request attribute
        Object attr = request.getAttribute(ApplicationHeadersUtils.CORRELATION_ID);
        if (attr instanceof String s && StringUtils.hasLength(s)) {
            return s;
        }

        value = UUID.randomUUID().toString();
        request.setAttribute(ApplicationHeadersUtils.CORRELATION_ID, value);

        return value;
    }

}

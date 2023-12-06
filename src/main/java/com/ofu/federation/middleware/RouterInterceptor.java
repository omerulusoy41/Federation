package com.ofu.federation.middleware;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class RouterInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
             Object handler
    ) {
        String routerSecret = System.getenv("ROUTER_SECRET");
        if (routerSecret == null) {
            return true;
        }
        String routerAuthorization = request.getHeader("Router-Authorization");
        if (routerSecret.equals(routerAuthorization)) {
            return true;
        }
        response.setStatus(401);
        return false;
    }
}

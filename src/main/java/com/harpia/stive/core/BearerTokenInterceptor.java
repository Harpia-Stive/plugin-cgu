package com.harpia.stive.core;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BearerTokenInterceptor extends HandlerInterceptorAdapter {

    private BearerTokenWrapper tokenWrapper;

    public BearerTokenInterceptor(BearerTokenWrapper tokenWrapper) {
        this.tokenWrapper = tokenWrapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        final String authorizationHeaderValue = request.getHeader("Authorization");
        
        String token = null;

        if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Bearer")) {
            token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
            tokenWrapper.setToken(token);

            if (BearerTokenWrapper.TOKEN_ESPERADO.equals(token)) {
                return true;
            }
        }

        response.setStatus(401);
        
        System.out.println("Time: "+ LocalDate.now() + " -- Tentantiva de acesso não autorizado! ");
        System.out.println("Time: "+ LocalDate.now() + ", Host: " + request.getRemoteHost() + ", Addr: " + request.getRemoteAddr() + ", Query: " + request.getQueryString()
        + ", URI: " + request.getRequestURI() + ", metodo: " + request.getMethod() + ", port: " + request.getRemotePort() + ", auth: " + request.getAuthType()
        + ", local port: " + request.getServerPort());

        return false;
    }
}

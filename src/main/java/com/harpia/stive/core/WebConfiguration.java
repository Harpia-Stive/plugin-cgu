
package com.harpia.stive.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter { /* or WebMvcConfigurerAdapter for Spring 4 */

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(bearerTokenInterceptor());
  }

  @Bean
  public BearerTokenInterceptor bearerTokenInterceptor() {
      return new BearerTokenInterceptor(bearerTokenWrapper());
  }

  @Bean
  @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
  public BearerTokenWrapper bearerTokenWrapper() {
    return new BearerTokenWrapper();
  }
}

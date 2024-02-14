package com.quantcast.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CookieBeanCreator {

    @Bean
    public CookieFinder cookieFilter() {
        return new CookieFinder();
    }

    @Bean
    public CookieFileExecutor cookieFileExecutor() {
        return new CookieFileExecutor();

    }
}

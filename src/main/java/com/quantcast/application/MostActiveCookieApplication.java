package com.quantcast.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MostActiveCookieApplication  implements CommandLineRunner {

    private CookieFileExecutor cookieFileExecutor;

    public static void main(String[] args) {
        SpringApplication.run(MostActiveCookieApplication.class, args);
    }

    @Override
    public void run(String[] args) {
        cookieFileExecutor = new CookieFileExecutor();
        cookieFileExecutor.executeProcess(args);
    }

}

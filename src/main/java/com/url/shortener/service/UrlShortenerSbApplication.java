package com.url.shortener.service;//package com.url.shortener.service;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class UrlShortenerSbApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(UrlShortenerSbApplication.class, args);
//	}
//
//}

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.url.shortener.repository")
@EntityScan("com.url.shortener.models")
@ComponentScan("com.url.shortener")
public class UrlShortenerSbApplication {
	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerSbApplication.class, args);
	}
}

package com.javaex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // 경로(확인 잘하기!!)
				.allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("http://localhost:8080");	//포트번호 맞춰줘야한다
	}
}

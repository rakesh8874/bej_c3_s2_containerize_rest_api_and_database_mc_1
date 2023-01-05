package com.niit.backendc3_s1_pc_1;

import com.niit.backendc3_s1_pc_1.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendC3S1Pc1Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendC3S1Pc1Application.class, args);
	}

	@Bean
	public FilterRegistrationBean  jwtFilter(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new JwtFilter());
		frb.addUrlPatterns("/api/v1/*");
		return frb;
	}


}

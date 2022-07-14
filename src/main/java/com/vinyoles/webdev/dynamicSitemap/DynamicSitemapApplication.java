package com.vinyoles.webdev.dynamicSitemap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DynamicSitemapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicSitemapApplication.class, args);
	}
	
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DynamicSitemapApplication.class);
    }
}

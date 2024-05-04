package com.ivansan.blogfinalproject;

import com.ivansan.blogfinalproject.config.RSAKeyProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = {RSAKeyProperties.class})
public class BlogFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogFinalProjectApplication.class, args);
	}

}

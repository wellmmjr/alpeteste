package org.example.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.example"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfo(
				"RESTful API With SpringBoot 2.1.3", 
				"CRUD pequeno e simples para estudar REST", 
				"v1", 
				"Terms of Service URL", 
				new Contact("Wellington Mendes", "https://github.com/wellmmjr", null), 
				"License Terms of API", 
				"License Terms URL", 
				Collections.emptyList()
			);
	}
}

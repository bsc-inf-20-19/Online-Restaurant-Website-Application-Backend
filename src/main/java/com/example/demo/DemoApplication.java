package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;



@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Primary
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo."))
				.paths(PathSelectors.any())

				.build()
				.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Online Restaurant API",
				"Online Restaurant Website Application api has been designed by Mphatso MPhepo Reg#: bsc-inf-20-19. The api is using java 11, the system is able to get, post, delete, patch, put information according to the users demands. Build tool: MAVEN, Email: bsc-inf-20-19@unima.ac.mw. This system is designed in a such a way that people will be order to press their orders on the website and then the restaurant will get notified of the order and then ask the customer to pay for the order through the mode of payment of his/her choice. Then after, the food will be prepared for the customer. When the food is ready, the system will be able to ask the customer if he/she wants the food to be delivered or not. The most interesting thing about this website is that people will also be able to comment on the food being offered through the comment section and also other restaurants will be able to come on this site and advertise their food but then these people will need to sign in into the system and they will be given some privileges",
				"6.0",
				"Terms of service",
				new Contact("Mphatso mphepo", "https://onlinerestaurantapi.herokuapp.com/swagger-ui.html", "bsc-inf-20-19@unima.ac.mw"),
				"License of API", "API license URL", Collections.emptyList());
	}
}

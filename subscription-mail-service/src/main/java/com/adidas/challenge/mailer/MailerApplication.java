package com.adidas.challenge.mailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class MailerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailerApplication.class, args);
    }

    @Bean
    public Docket api() {

        ApiInfo API_INFO = new ApiInfoBuilder()
                .description("Subscription mail is exposed through a microservice")
                .title("Subscription mail service")
                .version("0.0.1-SNAPSHOT").build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }
}
package com.anz.wholesale.account.config;

import io.swagger.annotations.SwaggerDefinition;
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
@SwaggerDefinition(produces = "application/json", schemes = {SwaggerDefinition.Scheme.HTTP})
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.anz.wholesale.account.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Account API", "Account Api to get the account and transaction list.",
                "1.0", "Terms of service", new Contact("Saurabh R", "www.anz.com", "saurabh.ranjan@anz.com"),
                "ANZ Wholesale 1.0", "API license URL", ApiInfo.DEFAULT.getVendorExtensions());
    }
}
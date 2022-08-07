package com.spring.features.Spring.Features;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apicConfigDocs() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.spring.features.Spring.Features.resources"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo infoDocs() {
        return new ApiInfo(
                "Title - Rest API",
                "My Description",
                "1.0",
                "Terms",
                new Contact(
                        "Marcos",
                        "https://marcos.com",
                        "marcos.rodrigues.dev@gmail.com"
                ),
                "Apache License",
                "url",
                new ArrayList<VendorExtension>()
        );
    }


}

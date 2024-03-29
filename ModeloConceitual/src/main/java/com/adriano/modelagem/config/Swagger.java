package com.adriano.modelagem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
    private static final String AUTHORIZATION = "Authorization";
    private static final String HEADER = "header";


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
//                .securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Arrays.asList(securityContext()));
    }


//    private ApiKey apiKey() {
//        return new ApiKey("Authorization", "Authorization", "header");
//    }
//
//    private SecurityContext securityContext() {
//        AuthorizationScope[] authScopes = new AuthorizationScope[1];
//        authScopes[0] = new AuthorizationScopeBuilder().scope("global").description("full access")
//                .build();
//
//        SecurityReference securityReference = SecurityReference.builder().reference("Authorization")
//                .scopes(authScopes).build();
//
//        return SecurityContext.builder().securityReferences(
//                Arrays.asList(securityReference)
//        ).build();
//    }


}
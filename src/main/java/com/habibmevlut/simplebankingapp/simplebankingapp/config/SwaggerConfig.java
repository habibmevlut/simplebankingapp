package com.habibmevlut.simplebankingapp.simplebankingapp.config;

import com.google.common.base.Predicates;
import jdk.jfr.Percentage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("com.habibmevlut.simplebankingapp.simplebankingapp"))
//                .paths(PathSelectors.regex("/.*"))
//                .build().apiInfo(apiEndPointsInfo());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.habibmevlut.simplebankingapp.simplebankingapp")).build();

    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Simple Banking API")
                .description("This is about Simple Bank Example Api Documentations")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("V1.0")
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Simple Banking API")
                .description("This is about Simple Bank Example Api Documentations")
                .version("V1.0").build();
    }
}

package com.github.liuweijw.core.configuration;

import io.swagger.annotations.ApiOperation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API 文档配置
 * 
 * @author liuweijw
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(" Swagger API ")
                .description("https://github.com/liuweijw/fw-cloud-framework/wiki")
                .termsOfServiceUrl("https://github.com/liuweijw/fw-cloud-framework")
                .contact(new Contact("liuweijw","https://github.com/liuweijw/fw-cloud-framework","liuweijw.github@foxmail.com"))
                .version("1.0")
                .build();
    }

}
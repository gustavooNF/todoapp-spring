package br.com.fiap.todoapp.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("br.com.fiap.todoapp.controller")).build();
    }
    
    private Predicate<String> postPaths() {
        return ((Predicate<String>) regex("/api/posts.*")::apply).or(regex("/api/javainuse.*")::apply);
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("MBA FIAP")
                .description("API para criação de tarefas")
                .termsOfServiceUrl("http://javainuse.com")
                .contact(new Contact("JavaInUse", "https://javainuse.com","javainuse@gmail.com"))
                .license("JavaInUse License")
                .version("1.0").build();
    }
}
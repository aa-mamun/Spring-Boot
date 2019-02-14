package com.mamun.swaggerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SwaggerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoApplication.class, args);
    }

    /**
     * URl - http://localhost:8080/swagger-ui.html
     * */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("REST API")
                .version("1.0")
                .license("All rights reserved.")
                .build();
    }

}


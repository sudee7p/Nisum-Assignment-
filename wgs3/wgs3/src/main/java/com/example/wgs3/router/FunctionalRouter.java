package com.example.wgs3.router;


import com.example.wgs3.handler.FunctionalHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class FunctionalRouter {

    @Bean
    public RouterFunction<ServerResponse> route(FunctionalHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello"), handler::hello)
                .andRoute(RequestPredicates.GET("/time"), handler::time);
    }
}

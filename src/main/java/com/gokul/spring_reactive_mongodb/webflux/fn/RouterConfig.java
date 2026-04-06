package com.gokul.spring_reactive_mongodb.webflux.fn;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;



import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RouterConfig {

    public static final String STUDENT = "/api/student";
    public static final String STUDENT_ID = "/api/student/{studentId}";

    private final WebFluxHandler handler;

    @Bean
    public RouterFunction<ServerResponse> studentRoutes() {
        return route()
                .GET(STUDENT, accept(APPLICATION_JSON), handler::findAll)
                .GET(STUDENT_ID, accept(APPLICATION_JSON), handler::findById)
                .POST(STUDENT, accept(APPLICATION_JSON), handler::saveStudent)
                .DELETE(STUDENT_ID,accept(APPLICATION_JSON),handler::deleteStudent)
                .PUT(STUDENT_ID,accept(APPLICATION_JSON),handler::updateStudent)
                .build();
    }
}

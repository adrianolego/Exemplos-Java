package com.example.webflux.router;

import com.example.webflux.handler.PlaylistHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

public class PlaylistRouter {
// Essa classe faz o mapeamento dos métodos que serão chamados na classe handler
    @Bean
    public RouterFunction<ServerResponse> reouter(PlaylistHandler playlistHandler) {
        return RouterFunctions
                .route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::findAll)
                .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::findById)
                .andRoute(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::findAll);
    }
}

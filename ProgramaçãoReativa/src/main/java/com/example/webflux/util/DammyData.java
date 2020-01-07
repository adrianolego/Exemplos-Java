package com.example.webflux.util;

import com.example.webflux.document.Playlist;
import com.example.webflux.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class DammyData implements CommandLineRunner {
    @Autowired
    private PlaylistRepository playlistRepository;

//    DammyData(PlaylistRepository playlistRepository) {
//        this.playlistRepository = playlistRepository;
//    }

    @Override
    public void run(String... args) throws Exception {
//        playlistRepository.deleteAll()
//                .thenMany(Flux.just("Java", "Jboss","GitHub", "Spring Boot", "WebService RestFull")
//                        .map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
//                        .flatMap(playlistRepository::save))
//                .subscribe(System.out::println);

    }
}

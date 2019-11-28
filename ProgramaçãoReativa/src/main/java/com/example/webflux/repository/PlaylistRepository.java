package com.example.webflux.repository;

import com.example.webflux.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}

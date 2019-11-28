package com.example.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Playlist {
    @Id
    String id;
    String nome;

    public Playlist(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public Playlist setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Playlist setNome(String nome) {
        this.nome = nome;
        return this;
    }
}

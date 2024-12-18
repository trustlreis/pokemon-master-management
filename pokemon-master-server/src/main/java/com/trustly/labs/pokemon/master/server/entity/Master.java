package com.trustly.labs.pokemon.master.server.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Handle serialization of nested `PokemonDeck`
    private List<PokemonDeck> pokemonDeck = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonDeck> getPokemonDeck() {
        return pokemonDeck;
    }

    public void setPokemonDeck(List<PokemonDeck> pokemonDeck) {
        this.pokemonDeck = pokemonDeck;
    }
}

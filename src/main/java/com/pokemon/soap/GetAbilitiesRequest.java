package com.pokemon.soap;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "getAbilitiesRequest", namespace = "http://pokemon.com/api/soap")
public class GetAbilitiesRequest {

    private String pokemonName;

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String value) {
        this.pokemonName = value;
    }
}
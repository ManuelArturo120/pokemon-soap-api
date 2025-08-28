package com.pokemon.soap;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"pokemonName"})
@XmlRootElement(name = "getIdRequest", namespace = "http://pokemon.com/api/soap")
public class GetIdRequest {
    
    @XmlElement(name = "pokemonName", namespace = "http://pokemon.com/api/soap", required = true)
    protected String pokemonName;

    public String getPokemonName() { return pokemonName; }
    public void setPokemonName(String value) { this.pokemonName = value; }
}
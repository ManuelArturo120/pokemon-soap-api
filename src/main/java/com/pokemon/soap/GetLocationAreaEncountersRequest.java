package com.pokemon.soap;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"pokemonName"})
@XmlRootElement(name = "getLocationAreaEncountersRequest", namespace = "http://pokemon.com/api/soap")
public class GetLocationAreaEncountersRequest {
    @XmlElement(required = true)
    protected String pokemonName;

    public String getPokemonName() { return pokemonName; }
    public void setPokemonName(String value) { this.pokemonName = value; }
}
package com.pokemon.soap;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"abilities"})
@XmlRootElement(name = "getAbilitiesResponse", namespace = "http://pokemon.com/api/soap")
public class GetAbilitiesResponse {

    @XmlElement(name = "abilities", namespace = "http://pokemon.com/api/soap")
    protected List<String> abilities;

    public List<String> getAbilities() {
        if (abilities == null) {
            abilities = new ArrayList<>();
        }
        return this.abilities;
    }
}
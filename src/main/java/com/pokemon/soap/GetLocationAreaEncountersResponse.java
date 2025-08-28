package com.pokemon.soap;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"locationAreaEncounters"})
@XmlRootElement(name = "getLocationAreaEncountersResponse", namespace = "http://pokemon.com/api/soap")
public class GetLocationAreaEncountersResponse {
    @XmlElement(required = true)
    protected List<String> locationAreaEncounters;

    public List<String> getLocationAreaEncounters() {
        if (locationAreaEncounters == null) {
            locationAreaEncounters = new ArrayList<>();
        }
        return this.locationAreaEncounters;
    }
}
package com.pokemon.soap;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"heldItems"})
@XmlRootElement(name = "getHeldItemsResponse", namespace = "http://pokemon.com/api/soap")
public class GetHeldItemsResponse {
    @XmlElement(required = true)
    protected List<String> heldItems;

    public List<String> getHeldItems() {
        if (heldItems == null) {
            heldItems = new ArrayList<>();
        }
        return this.heldItems;
    }
}
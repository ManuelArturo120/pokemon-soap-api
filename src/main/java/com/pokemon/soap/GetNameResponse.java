package com.pokemon.soap;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"name"})
@XmlRootElement(name = "getNameResponse", namespace = "http://pokemon.com/api/soap")
public class GetNameResponse {
    @XmlElement(required = true)
    protected String name;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
}
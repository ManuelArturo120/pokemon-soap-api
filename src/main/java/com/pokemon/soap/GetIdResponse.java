package com.pokemon.soap;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"id"})
@XmlRootElement(name = "getIdResponse", namespace = "http://pokemon.com/api/soap")
public class GetIdResponse {
    
    @XmlElement(name = "id", namespace = "http://pokemon.com/api/soap")
    protected int id;

    public int getId() { return id; }
    public void setId(int value) { this.id = value; }
}
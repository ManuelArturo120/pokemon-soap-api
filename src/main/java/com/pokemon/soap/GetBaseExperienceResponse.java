package com.pokemon.soap;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"baseExperience"})
@XmlRootElement(name = "getBaseExperienceResponse", namespace = "http://pokemon.com/api/soap")
public class GetBaseExperienceResponse {
    protected int baseExperience;

    public int getBaseExperience() { return baseExperience; }
    public void setBaseExperience(int value) { this.baseExperience = value; }
}
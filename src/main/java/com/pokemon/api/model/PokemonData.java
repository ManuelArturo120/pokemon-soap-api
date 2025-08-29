package com.pokemon.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PokemonData {
    
    private List<Ability> abilities;
    
    @JsonProperty("base_experience")
    private Integer baseExperience;
    
    @JsonProperty("held_items")
    private List<HeldItem> heldItems;
    
    private Integer id;
    private String name;
    
    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;

    // Nested classes
    public static class Ability {
        private AbilityDetail ability;
        
        public AbilityDetail getAbility() { return ability; }
        public void setAbility(AbilityDetail ability) { this.ability = ability; }
    }
    
    public static class AbilityDetail {
        private String name;
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
    
    public static class HeldItem {
        private ItemDetail item;
        
        public ItemDetail getItem() { return item; }
        public void setItem(ItemDetail item) { this.item = item; }
    }
    
    public static class ItemDetail {
        private String name;
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    // Getters and Setters
    public List<Ability> getAbilities() { return abilities; }
    public void setAbilities(List<Ability> abilities) { this.abilities = abilities; }

    public Integer getBaseExperience() { return baseExperience; }
    public void setBaseExperience(Integer baseExperience) { this.baseExperience = baseExperience; }

    public List<HeldItem> getHeldItems() { return heldItems; }
    public void setHeldItems(List<HeldItem> heldItems) { this.heldItems = heldItems; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocationAreaEncounters() { return locationAreaEncounters; }
    public void setLocationAreaEncounters(String locationAreaEncounters) { 
        this.locationAreaEncounters = locationAreaEncounters; 
    }
}
package com.pokemon.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pokemon_requests")
public class PokemonRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "origin_ip", nullable = false)
    private String originIp;
    
    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;
    
    @Column(name = "method_executed", nullable = false)
    private String methodExecuted;
    
    @Column(name = "pokemon_name", nullable = true)
    private String pokemonName;
    
    @Column(name = "duration_ms")
    private Long durationMs;
    
    @Column(name = "response_status")
    private String responseStatus;

    public PokemonRequest() {}

    public PokemonRequest(String originIp, String methodExecuted, String pokemonName) {
        this.originIp = originIp;
        this.requestDate = LocalDateTime.now();
        this.methodExecuted = methodExecuted;
        this.pokemonName = pokemonName;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOriginIp() { return originIp; }
    public void setOriginIp(String originIp) { this.originIp = originIp; }

    public LocalDateTime getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }

    public String getMethodExecuted() { return methodExecuted; }
    public void setMethodExecuted(String methodExecuted) { this.methodExecuted = methodExecuted; }

    public String getPokemonName() { return pokemonName; }
    public void setPokemonName(String pokemonName) { this.pokemonName = pokemonName; }

    public Long getDurationMs() { return durationMs; }
    public void setDurationMs(Long durationMs) { this.durationMs = durationMs; }

    public String getResponseStatus() { return responseStatus; }
    public void setResponseStatus(String responseStatus) { this.responseStatus = responseStatus; }
}
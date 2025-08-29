package com.pokemon.api.service;

import com.pokemon.api.model.PokemonData;
import com.pokemon.api.model.PokemonRequest;
import com.pokemon.api.repository.PokemonRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final WebClient webClient;
    private final PokemonRequestRepository requestRepository;
    private static final String POKEMON_API_URL = "https://pokeapi.co/api/v2/pokemon/";

    @Autowired
    public PokemonService(WebClient.Builder webClientBuilder, PokemonRequestRepository requestRepository) {
        this.webClient = webClientBuilder.baseUrl(POKEMON_API_URL).build();
        this.requestRepository = requestRepository;
    }

    public List<String> getAbilities(String pokemonName, String originIp) {
        long startTime = System.currentTimeMillis();
        String safePokemonName = (pokemonName != null && !pokemonName.trim().isEmpty()) ? pokemonName.trim() : "pikachu";
        
        try {
            PokemonData pokemon = fetchPokemonData(safePokemonName);
            List<String> abilities = pokemon.getAbilities().stream()
                    .map(ability -> ability.getAbility().getName())
                    .collect(Collectors.toList());
            
            // Save request log
            PokemonRequest request = new PokemonRequest();
            request.setOriginIp(originIp != null ? originIp : "127.0.0.1");
            request.setMethodExecuted("getAbilities");
            request.setPokemonName(safePokemonName);
            request.setRequestDate(java.time.LocalDateTime.now());
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("SUCCESS");
            requestRepository.save(request);
            
            return abilities;
        } catch (Exception e) {
            // Save error log
            PokemonRequest request = new PokemonRequest();
            request.setOriginIp(originIp != null ? originIp : "127.0.0.1");
            request.setMethodExecuted("getAbilities");
            request.setPokemonName(safePokemonName);
            request.setRequestDate(java.time.LocalDateTime.now());
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("ERROR: " + e.getMessage());
            requestRepository.save(request);
            
            throw new RuntimeException("Error fetching abilities for " + safePokemonName, e);
        }
    }

    public Integer getBaseExperience(String pokemonName, String originIp) {
        long startTime = System.currentTimeMillis();
        PokemonRequest request = new PokemonRequest(originIp, "getBaseExperience", pokemonName);
        
        try {
            PokemonData pokemon = fetchPokemonData(pokemonName);
            Integer baseExperience = pokemon.getBaseExperience();
            
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("SUCCESS");
            requestRepository.save(request);
            
            return baseExperience;
        } catch (Exception e) {
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("ERROR: " + e.getMessage());
            requestRepository.save(request);
            throw new RuntimeException("Error fetching base experience for " + pokemonName, e);
        }
    }

    public List<String> getHeldItems(String pokemonName, String originIp) {
        long startTime = System.currentTimeMillis();
        PokemonRequest request = new PokemonRequest(originIp, "getHeldItems", pokemonName);
        
        try {
            PokemonData pokemon = fetchPokemonData(pokemonName);
            List<String> heldItems = pokemon.getHeldItems().stream()
                    .map(item -> item.getItem().getName())
                    .collect(Collectors.toList());
            
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("SUCCESS");
            requestRepository.save(request);
            
            return heldItems;
        } catch (Exception e) {
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("ERROR: " + e.getMessage());
            requestRepository.save(request);
            throw new RuntimeException("Error fetching held items for " + pokemonName, e);
        }
    }

    public Integer getId(String pokemonName, String originIp) {
        long startTime = System.currentTimeMillis();
        
        try {
            PokemonData pokemon = fetchPokemonData(pokemonName != null ? pokemonName : "pikachu");
            Integer id = pokemon.getId();
            
            // Save request log
            PokemonRequest request = new PokemonRequest();
            request.setOriginIp(originIp != null ? originIp : "127.0.0.1");
            request.setMethodExecuted("getId");
            request.setPokemonName(pokemonName != null ? pokemonName : "pikachu");
            request.setRequestDate(java.time.LocalDateTime.now());
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("SUCCESS");
            requestRepository.save(request);
            
            return id;
        } catch (Exception e) {
            // Save error log
            PokemonRequest request = new PokemonRequest();
            request.setOriginIp(originIp != null ? originIp : "127.0.0.1");
            request.setMethodExecuted("getId");
            request.setPokemonName(pokemonName != null ? pokemonName : "pikachu");
            request.setRequestDate(java.time.LocalDateTime.now());
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("ERROR: " + e.getMessage());
            requestRepository.save(request);
            
            throw new RuntimeException("Error fetching ID for " + pokemonName, e);
        }
    }

    public String getName(String pokemonName, String originIp) {
        long startTime = System.currentTimeMillis();
        PokemonRequest request = new PokemonRequest(originIp, "getName", pokemonName);
        
        try {
            PokemonData pokemon = fetchPokemonData(pokemonName);
            String name = pokemon.getName();
            
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("SUCCESS");
            requestRepository.save(request);
            
            return name;
        } catch (Exception e) {
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("ERROR: " + e.getMessage());
            requestRepository.save(request);
            throw new RuntimeException("Error fetching name for " + pokemonName, e);
        }
    }

    public List<String> getLocationAreaEncounters(String pokemonName, String originIp) {
        long startTime = System.currentTimeMillis();
        PokemonRequest request = new PokemonRequest(originIp, "getLocationAreaEncounters", pokemonName);
        
        try {
            // First get pokemon data to get the location_area_encounters URL
            PokemonData pokemon = fetchPokemonData(pokemonName);
            String locationUrl = pokemon.getLocationAreaEncounters();
            
            // Fetch location data if URL exists
            List<String> locations = List.of(); // Default empty list
            if (locationUrl != null && !locationUrl.isEmpty()) {
                // This would require additional API call to the location URL
                // For simplicity, returning the URL as a single item
                locations = List.of(locationUrl);
            }
            
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("SUCCESS");
            requestRepository.save(request);
            
            return locations;
        } catch (Exception e) {
            request.setDurationMs(System.currentTimeMillis() - startTime);
            request.setResponseStatus("ERROR: " + e.getMessage());
            requestRepository.save(request);
            throw new RuntimeException("Error fetching location area encounters for " + pokemonName, e);
        }
    }

    private PokemonData fetchPokemonData(String pokemonName) {
        String name = (pokemonName != null && !pokemonName.trim().isEmpty()) ? pokemonName.trim() : "pikachu";
        
        try {
            return webClient.get()
                    .uri(name.toLowerCase())
                    .retrieve()
                    .bodyToMono(PokemonData.class)
                    .timeout(java.time.Duration.ofSeconds(10))
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching Pokemon data for: " + name + ". Error: " + e.getMessage(), e);
        }
    }
}
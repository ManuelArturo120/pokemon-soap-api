package com.pokemon.api.controller;

import com.pokemon.api.service.PokemonService;
import com.pokemon.soap.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@Endpoint
public class PokemonSoapController {

    private static final String NAMESPACE_URI = "http://pokemon.com/api/soap";
    
    @Autowired
    private PokemonService pokemonService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
    public GetAbilitiesResponse getAbilities(@RequestPayload org.w3c.dom.Element requestElement) {
        String originIp = getClientIpAddress();
        
        // Extract pokemonName from DOM
        String pokemonName = null;
        try {
            org.w3c.dom.NodeList nodes = requestElement.getElementsByTagName("pokemonName");
            if (nodes.getLength() > 0) {
                pokemonName = nodes.item(0).getTextContent();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error extracting pokemonName: " + e.getMessage());
        }
        
        if (pokemonName == null || pokemonName.trim().isEmpty()) {
            throw new IllegalArgumentException("pokemonName is required");
        }
        
        System.out.println("DEBUG: Extracted pokemonName: " + pokemonName);
        
        List<String> abilities = pokemonService.getAbilities(pokemonName, originIp);
        
        GetAbilitiesResponse response = new GetAbilitiesResponse();
        response.getAbilities().addAll(abilities);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
    public GetBaseExperienceResponse getBaseExperience(@RequestPayload org.w3c.dom.Element requestElement) {
        String originIp = getClientIpAddress();
        String pokemonName = null;
        try {
            org.w3c.dom.NodeList nodes = requestElement.getElementsByTagName("pokemonName");
            if (nodes.getLength() > 0) {
                pokemonName = nodes.item(0).getTextContent();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error extracting pokemonName: " + e.getMessage());
        }
        
        if (pokemonName == null || pokemonName.trim().isEmpty()) {
            throw new IllegalArgumentException("pokemonName is required");
        }
        
        Integer baseExperience = pokemonService.getBaseExperience(pokemonName, originIp);
        
        GetBaseExperienceResponse response = new GetBaseExperienceResponse();
        response.setBaseExperience(baseExperience);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
    public GetHeldItemsResponse getHeldItems(@RequestPayload org.w3c.dom.Element requestElement) {
        String originIp = getClientIpAddress();
        String pokemonName = null;
        try {
            org.w3c.dom.NodeList nodes = requestElement.getElementsByTagName("pokemonName");
            if (nodes.getLength() > 0) {
                pokemonName = nodes.item(0).getTextContent();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error extracting pokemonName: " + e.getMessage());
        }
        
        if (pokemonName == null || pokemonName.trim().isEmpty()) {
            throw new IllegalArgumentException("pokemonName is required");
        }
        
        List<String> heldItems = pokemonService.getHeldItems(pokemonName, originIp);
        
        GetHeldItemsResponse response = new GetHeldItemsResponse();
        response.getHeldItems().addAll(heldItems);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
    public GetIdResponse getId(@RequestPayload org.w3c.dom.Element requestElement) {
        String originIp = getClientIpAddress();
        String pokemonName = null;
        try {
            org.w3c.dom.NodeList nodes = requestElement.getElementsByTagName("pokemonName");
            if (nodes.getLength() > 0) {
                pokemonName = nodes.item(0).getTextContent();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error extracting pokemonName: " + e.getMessage());
        }
        
        if (pokemonName == null || pokemonName.trim().isEmpty()) {
            throw new IllegalArgumentException("pokemonName is required");
        }
        
        Integer id = pokemonService.getId(pokemonName, originIp);
        
        GetIdResponse response = new GetIdResponse();
        response.setId(id);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public GetNameResponse getName(@RequestPayload org.w3c.dom.Element requestElement) {
        String originIp = getClientIpAddress();
        String pokemonName = null;
        try {
            org.w3c.dom.NodeList nodes = requestElement.getElementsByTagName("pokemonName");
            if (nodes.getLength() > 0) {
                pokemonName = nodes.item(0).getTextContent();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error extracting pokemonName: " + e.getMessage());
        }
        
        if (pokemonName == null || pokemonName.trim().isEmpty()) {
            throw new IllegalArgumentException("pokemonName is required");
        }
        
        String name = pokemonService.getName(pokemonName, originIp);
        
        GetNameResponse response = new GetNameResponse();
        response.setName(name);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
    public GetLocationAreaEncountersResponse getLocationAreaEncounters(@RequestPayload org.w3c.dom.Element requestElement) {
        String originIp = getClientIpAddress();
        String pokemonName = null;
        try {
            org.w3c.dom.NodeList nodes = requestElement.getElementsByTagName("pokemonName");
            if (nodes.getLength() > 0) {
                pokemonName = nodes.item(0).getTextContent();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error extracting pokemonName: " + e.getMessage());
        }
        
        if (pokemonName == null || pokemonName.trim().isEmpty()) {
            throw new IllegalArgumentException("pokemonName is required");
        }
        
        List<String> locations = pokemonService.getLocationAreaEncounters(pokemonName, originIp);
        
        GetLocationAreaEncountersResponse response = new GetLocationAreaEncountersResponse();
        response.getLocationAreaEncounters().addAll(locations);
        return response;
    }

    private String getClientIpAddress() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedForHeader == null) {
            return request.getRemoteAddr();
        } else {
            return xForwardedForHeader.split(",")[0];
        }
    }
}
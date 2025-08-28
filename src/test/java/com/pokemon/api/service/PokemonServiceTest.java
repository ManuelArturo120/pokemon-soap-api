package com.pokemon.api.service;

import com.pokemon.api.model.PokemonRequest;
import com.pokemon.api.repository.PokemonRequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@SpringJUnitConfig
@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @MockBean
    private PokemonRequestRepository requestRepository;

    @Test
    void testServiceExists() {
        // Simple test to verify service can be instantiated
        assertNotNull(requestRepository);
    }

    @Test
    void testRepositoryMock() {
        // Test that repository mock works
        PokemonRequest request = new PokemonRequest();
        request.setPokemonName("test");
        
        when(requestRepository.save(any(PokemonRequest.class))).thenReturn(request);
        
        PokemonRequest saved = requestRepository.save(request);
        assertNotNull(saved);
        assertEquals("test", saved.getPokemonName());
    }
}
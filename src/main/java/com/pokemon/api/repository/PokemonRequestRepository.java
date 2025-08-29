package com.pokemon.api.repository;

import com.pokemon.api.model.PokemonRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRequestRepository extends JpaRepository<PokemonRequest, Long> {
}
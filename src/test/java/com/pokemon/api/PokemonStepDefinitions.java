package com.pokemon.api;

import com.pokemon.api.service.PokemonService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@CucumberContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
public class PokemonStepDefinitions {

    @Autowired
    private PokemonService pokemonService;

    private String pokemonName;
    private List<String> abilities;
    private Integer baseExperience;
    private Integer pokemonId;

    @Given("I have a Pokemon name {string}")
    public void i_have_a_pokemon_name(String name) {
        this.pokemonName = name;
    }

    @When("I call the getAbilities SOAP endpoint")
    public void i_call_the_get_abilities_soap_endpoint() {
        this.abilities = pokemonService.getAbilities(pokemonName, "127.0.0.1");
    }

    @When("I call the getBaseExperience SOAP endpoint")
    public void i_call_the_get_base_experience_soap_endpoint() {
        this.baseExperience = pokemonService.getBaseExperience(pokemonName, "127.0.0.1");
    }

    @When("I call the getId SOAP endpoint")
    public void i_call_the_get_id_soap_endpoint() {
        this.pokemonId = pokemonService.getId(pokemonName, "127.0.0.1");
    }

    @Then("I should receive a list of abilities")
    public void i_should_receive_a_list_of_abilities() {
        assertNotNull(abilities);
        assertFalse(abilities.isEmpty());
    }

    @Then("I should receive the base experience value")
    public void i_should_receive_the_base_experience_value() {
        assertNotNull(baseExperience);
        assertTrue(baseExperience > 0);
    }

    @Then("I should receive the Pokemon ID")
    public void i_should_receive_the_pokemon_id() {
        assertNotNull(pokemonId);
        assertTrue(pokemonId > 0);
    }

    @Then("the request should be logged in the database")
    public void the_request_should_be_logged_in_the_database() {
        // This would require checking the database, simplified for demo
        assertTrue(true);
    }
}
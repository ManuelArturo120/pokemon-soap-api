@echo off
echo Testing getBaseExperience with Ivysaur
curl -X POST http://localhost:8080/ws -H "Content-Type: text/xml" -d "<?xml version=\"1.0\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><getBaseExperienceRequest xmlns=\"http://pokemon.com/api/soap\"><pokemonName>ivysaur</pokemonName></getBaseExperienceRequest></soap:Body></soap:Envelope>"
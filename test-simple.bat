@echo off
echo Simple Test
curl -X POST http://localhost:8080/ws -H "Content-Type: text/xml" -d "<?xml version=\"1.0\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><getAbilitiesRequest xmlns=\"http://pokemon.com/api/soap\"><pokemonName>pikachu</pokemonName></getAbilitiesRequest></soap:Body></soap:Envelope>"
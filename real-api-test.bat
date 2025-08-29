@echo off
echo Real Pokemon API Test
echo.

echo Testing getAbilities for Pikachu:
curl -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml" ^
  -d "<?xml version=\"1.0\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><ns:getAbilitiesRequest xmlns:ns=\"http://pokemon.com/api/soap\"><ns:pokemonName>pikachu</ns:pokemonName></ns:getAbilitiesRequest></soap:Body></soap:Envelope>"

echo.
echo.

echo Testing getId for Charizard:
curl -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml" ^
  -d "<?xml version=\"1.0\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><ns:getIdRequest xmlns:ns=\"http://pokemon.com/api/soap\"><ns:pokemonName>charizard</ns:pokemonName></ns:getIdRequest></soap:Body></soap:Envelope>"

echo.
echo Done!
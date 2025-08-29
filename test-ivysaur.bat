@echo off
echo Testing with Ivysaur
echo.

curl -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml" ^
  -d "<?xml version=\"1.0\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><ns:getAbilitiesRequest xmlns:ns=\"http://pokemon.com/api/soap\"><ns:pokemonName>ivysaur</ns:pokemonName></ns:getAbilitiesRequest></soap:Body></soap:Envelope>"

echo.
echo Done!
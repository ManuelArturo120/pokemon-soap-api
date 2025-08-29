@echo off
echo Testing Pokemon SOAP API - Quick Test
echo.

echo Testing getId for Pikachu:
curl -X POST http://localhost:8080/ws -H "Content-Type: text/xml" -d "<?xml version=\"1.0\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://pokemon.com/api/soap\"><soapenv:Body><soap:getIdRequest><soap:pokemonName>pikachu</soap:pokemonName></soap:getIdRequest></soapenv:Body></soapenv:Envelope>"

echo.
echo.
echo Done!
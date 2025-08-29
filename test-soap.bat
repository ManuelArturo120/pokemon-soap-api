@echo off
echo Testing Pokemon SOAP API endpoints...
echo.

REM Test getAbilities
echo 1. Testing getAbilities for Pikachu:
curl -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml; charset=utf-8" ^
  -H "SOAPAction: " ^
  -d "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://pokemon.com/api/soap\"><soapenv:Header/><soapenv:Body><soap:getAbilitiesRequest><soap:pokemonName>pikachu</soap:pokemonName></soap:getAbilitiesRequest></soapenv:Body></soapenv:Envelope>"

echo.
echo.

REM Test getBaseExperience  
echo 2. Testing getBaseExperience for Pikachu:
curl -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml; charset=utf-8" ^
  -H "SOAPAction: " ^
  -d "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://pokemon.com/api/soap\"><soapenv:Header/><soapenv:Body><soap:getBaseExperienceRequest><soap:pokemonName>pikachu</soap:pokemonName></soap:getBaseExperienceRequest></soapenv:Body></soapenv:Envelope>"

echo.
echo.

REM Test getId
echo 3. Testing getId for Pikachu:
curl -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml; charset=utf-8" ^
  -H "SOAPAction: " ^
  -d "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://pokemon.com/api/soap\"><soapenv:Header/><soapenv:Body><soap:getIdRequest><soap:pokemonName>pikachu</soap:pokemonName></soap:getIdRequest></soapenv:Body></soapenv:Envelope>"

echo.
echo.

REM Test getName
echo 4. Testing getName for Pikachu:
curl -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml; charset=utf-8" ^
  -H "SOAPAction: " ^
  -d "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://pokemon.com/api/soap\"><soapenv:Header/><soapenv:Body><soap:getNameRequest><soap:pokemonName>pikachu</soap:pokemonName></soap:getNameRequest></soapenv:Body></soapenv:Envelope>"

echo.
echo.

REM Test getHeldItems
echo 5. Testing getHeldItems for Pikachu:
curl -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml; charset=utf-8" ^
  -H "SOAPAction: " ^
  -d "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://pokemon.com/api/soap\"><soapenv:Header/><soapenv:Body><soap:getHeldItemsRequest><soap:pokemonName>pikachu</soap:pokemonName></soap:getHeldItemsRequest></soapenv:Body></soapenv:Envelope>"

echo.
echo.

REM Test getLocationAreaEncounters
echo 6. Testing getLocationAreaEncounters for Pikachu:
curl -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml; charset=utf-8" ^
  -H "SOAPAction: " ^
  -d "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://pokemon.com/api/soap\"><soapenv:Header/><soapenv:Body><soap:getLocationAreaEncountersRequest><soap:pokemonName>pikachu</soap:pokemonName></soap:getLocationAreaEncountersRequest></soapenv:Body></soapenv:Envelope>"

echo.
echo.
echo Testing completed!
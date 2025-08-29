@echo off
echo Debug Test - Pokemon SOAP API
echo.

echo Checking if app is running...
curl -s http://localhost:8080/actuator/health

echo.
echo.
echo Testing WSDL access...
curl -s http://localhost:8080/ws/pokemon.wsdl | head -5

echo.
echo.
echo Testing SOAP endpoint...
curl -v -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml; charset=utf-8" ^
  -d "<?xml version=\"1.0\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://pokemon.com/api/soap\"><soapenv:Body><soap:getIdRequest><soap:pokemonName>pikachu</soap:pokemonName></soap:getIdRequest></soapenv:Body></soapenv:Envelope>"
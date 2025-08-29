@echo off
echo Working SOAP Test
echo.

echo Testing getId endpoint:
curl -v -X POST http://localhost:8080/ws ^
  -H "Content-Type: text/xml; charset=utf-8" ^
  -H "SOAPAction: \"\"" ^
  -d "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><ns:getIdRequest xmlns:ns=\"http://pokemon.com/api/soap\"><ns:pokemonName>pikachu</ns:pokemonName></ns:getIdRequest></soap:Body></soap:Envelope>"

echo.
echo Done!
# Comandos cURL para Probar Pokemon SOAP API

## Prerrequisitos
- Aplicación ejecutándose en http://localhost:8080
- cURL instalado

## 1. Obtener Habilidades (getAbilities)

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml; charset=utf-8" \
  -H "SOAPAction: " \
  -d '<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://pokemon.com/api/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getAbilitiesRequest>
         <soap:pokemonName>pikachu</soap:pokemonName>
      </soap:getAbilitiesRequest>
   </soapenv:Body>
</soapenv:Envelope>'
```

## 2. Obtener Experiencia Base (getBaseExperience)

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml; charset=utf-8" \
  -H "SOAPAction: " \
  -d '<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://pokemon.com/api/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getBaseExperienceRequest>
         <soap:pokemonName>pikachu</soap:pokemonName>
      </soap:getBaseExperienceRequest>
   </soapenv:Body>
</soapenv:Envelope>'
```

## 3. Obtener ID (getId)

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml; charset=utf-8" \
  -H "SOAPAction: " \
  -d '<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://pokemon.com/api/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getIdRequest>
         <soap:pokemonName>pikachu</soap:pokemonName>
      </soap:getIdRequest>
   </soapenv:Body>
</soapenv:Envelope>'
```

## 4. Obtener Nombre (getName)

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml; charset=utf-8" \
  -H "SOAPAction: " \
  -d '<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://pokemon.com/api/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getNameRequest>
         <soap:pokemonName>pikachu</soap:pokemonName>
      </soap:getNameRequest>
   </soapenv:Body>
</soapenv:Envelope>'
```

## 5. Obtener Objetos (getHeldItems)

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml; charset=utf-8" \
  -H "SOAPAction: " \
  -d '<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://pokemon.com/api/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getHeldItemsRequest>
         <soap:pokemonName>pikachu</soap:pokemonName>
      </soap:getHeldItemsRequest>
   </soapenv:Body>
</soapenv:Envelope>'
```

## 6. Obtener Ubicaciones (getLocationAreaEncounters)

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml; charset=utf-8" \
  -H "SOAPAction: " \
  -d '<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://pokemon.com/api/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getLocationAreaEncountersRequest>
         <soap:pokemonName>pikachu</soap:pokemonName>
      </soap:getLocationAreaEncountersRequest>
   </soapenv:Body>
</soapenv:Envelope>'
```

## Ejecutar Todas las Pruebas

### Windows:
```cmd
test-soap.bat
```

### Linux/Mac:
```bash
chmod +x test-soap.sh
./test-soap.sh
```

## Otros Pokemon para Probar

Reemplaza `pikachu` con:
- `charizard`
- `blastoise`
- `venusaur`
- `mewtwo`
- `mew`

## Verificar WSDL

```bash
curl http://localhost:8080/ws/pokemon.wsdl
```
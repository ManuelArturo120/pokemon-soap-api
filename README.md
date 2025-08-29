# Pokemon SOAP API

API SOAP para consumir datos de Pokemon desde https://pokeapi.co/

## Descripción

Este proyecto implementa una API SOAP que consume la API REST de Pokemon y expone los siguientes métodos:
- `abilities`: Obtiene las habilidades de un Pokemon
- `base_experience`: Obtiene la experiencia base de un Pokemon  
- `held_items`: Obtiene los objetos que puede portar un Pokemon
- `id`: Obtiene el ID de un Pokemon
- `name`: Obtiene el nombre de un Pokemon
- `location_area_encounters`: Obtiene las áreas donde se puede encontrar un Pokemon

## Tecnologías

- Java 17
- Spring Boot 3.2.0
- Spring Web Services (SOAP)
- Spring Data JPA
- H2 Database (desarrollo) / MySQL (producción)
- WebFlux (cliente HTTP)
- JUnit 5 + Mockito (pruebas unitarias)
- Cucumber (pruebas BDD)
- Docker
- SonarQube
- Swagger/OpenAPI

## Patrones de Diseño

- **Repository Pattern**: Para acceso a datos
- **Service Layer Pattern**: Lógica de negocio separada
- **DTO Pattern**: Transferencia de datos entre capas
- **Builder Pattern**: Configuración de WebClient

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/pokemon/api/
│   │   ├── config/          # Configuraciones
│   │   ├── controller/      # Controladores SOAP
│   │   ├── model/          # Entidades y DTOs
│   │   ├── repository/     # Repositorios JPA
│   │   ├── service/        # Servicios de negocio
│   │   └── soap/           # Clases generadas SOAP
│   └── resources/
│       ├── pokemon.xsd     # Esquema SOAP
│       └── application.yml # Configuración
└── test/
    ├── java/               # Pruebas unitarias y Cucumber
    └── resources/          # Features y configuración test
```

## Instalación y Ejecución

### Prerrequisitos
- Java 17+
- Maven 3.6+
- Docker (opcional)

### Ejecución Local

1. Clonar el repositorio:
```bash
git clone <repository-url>
cd pokemon-soap-api
```

2. Compilar el proyecto:
```bash
mvn clean compile
```

3. Ejecutar pruebas:
```bash
mvn test
```

4. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

La aplicación estará disponible en: http://localhost:8080

### Ejecución con Docker

1. Construir la imagen:
```bash
mvn clean package
docker build -t pokemon-soap-api .
```

2. Ejecutar con Docker Compose:
```bash
docker-compose up -d
```

## Endpoints

### SOAP WSDL
- WSDL: http://localhost:8080/ws/pokemon.wsdl

### Consola H2 (desarrollo)
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:pokemondb
- Usuario: sa
- Contraseña: password

### Swagger UI
- URL: http://localhost:8080/swagger-ui.html

## Uso de la API SOAP

### Ejemplo de Request SOAP

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:soap="http://pokemon.com/api/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getAbilitiesRequest>
         <soap:pokemonName>pikachu</soap:pokemonName>
      </soap:getAbilitiesRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Ejemplo de Response SOAP

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:getAbilitiesResponse xmlns:ns2="http://pokemon.com/api/soap">
         <ns2:abilities>static</ns2:abilities>
         <ns2:abilities>lightning-rod</ns2:abilities>
      </ns2:getAbilitiesResponse>
   </soap:Body>
</soap:Envelope>
```

## Análisis de Código

### SonarQube

1. Ejecutar análisis local:
```bash
mvn clean verify sonar:sonar
```

2. Para SonarCloud, configurar token:
```bash
mvn clean verify sonar:sonar -Dsonar.login=<your-token>
```

### Cobertura de Código

```bash
mvn clean test jacoco:report
```

El reporte estará en: `target/site/jacoco/index.html`

## Pruebas

### Pruebas Unitarias
```bash
mvn test
```

### Pruebas Cucumber
```bash
mvn test -Dtest=CucumberTest
```

## Estrategia de Branching

### GitFlow

- **main**: Rama principal de producción
- **develop**: Rama de desarrollo
- **feature/**: Nuevas funcionalidades
- **release/**: Preparación de releases
- **hotfix/**: Correcciones urgentes

### Flujo de Trabajo

1. Crear feature branch desde develop:
```bash
git checkout develop
git pull origin develop
git checkout -b feature/nueva-funcionalidad
```

2. Desarrollar y hacer commits:
```bash
git add .
git commit -m "feat: agregar nueva funcionalidad"
```

3. Push y crear Pull Request:
```bash
git push origin feature/nueva-funcionalidad
```

4. Merge a develop después de review
5. Deploy a staging desde develop
6. Merge a main para producción

### Convenciones de Commits

- `feat:` Nueva funcionalidad
- `fix:` Corrección de bug
- `docs:` Documentación
- `style:` Formato de código
- `refactor:` Refactorización
- `test:` Pruebas
- `chore:` Tareas de mantenimiento

## Validación del Desarrollo

### Checklist de Validación

- [ ] Compilación exitosa: `mvn clean compile`
- [ ] Pruebas unitarias pasan: `mvn test`
- [ ] Cobertura de código > 80%
- [ ] Análisis SonarQube sin issues críticos
- [ ] Pruebas Cucumber pasan
- [ ] Aplicación inicia correctamente
- [ ] Endpoints SOAP responden correctamente
- [ ] Base de datos registra peticiones
- [ ] Docker build exitoso
- [ ] Documentación actualizada

### Comandos de Validación

```bash
# Validación completa
mvn clean verify

# Análisis de calidad
mvn sonar:sonar

# Pruebas de integración
mvn test -Dtest=CucumberTest

# Construcción Docker
docker build -t pokemon-soap-api .
docker run -p 8080:8080 pokemon-soap-api
```

## Monitoreo

### Métricas Disponibles
- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/metrics
- http://localhost:8080/actuator/info

### Logs de Peticiones

Todas las peticiones se registran en la tabla `pokemon_requests` con:
- IP de origen
- Fecha de petición
- Método ejecutado
- Nombre del Pokemon
- Duración de la petición
- Estado de la respuesta

## Contribución

1. Fork del proyecto
2. Crear feature branch
3. Hacer commits siguiendo convenciones
4. Ejecutar pruebas y validaciones
5. Crear Pull Request
6. Code review y merge

## Licencia

MIT License
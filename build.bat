@echo off
echo ========================================
echo Pokemon SOAP API - Build and Validation
echo ========================================

echo.
echo 1. Cleaning project...
call mvn clean

echo.
echo 2. Compiling project...
call mvn compile
if %errorlevel% neq 0 (
    echo ERROR: Compilation failed
    exit /b 1
)

echo.
echo 3. Running unit tests...
call mvn test
if %errorlevel% neq 0 (
    echo ERROR: Tests failed
    exit /b 1
)

echo.
echo 4. Generating test coverage report...
call mvn jacoco:report

echo.
echo 5. Packaging application...
call mvn package -DskipTests
if %errorlevel% neq 0 (
    echo ERROR: Packaging failed
    exit /b 1
)

echo.
echo 6. Building Docker image...
docker build -t pokemon-soap-api .
if %errorlevel% neq 0 (
    echo ERROR: Docker build failed
    exit /b 1
)

echo.
echo ========================================
echo BUILD SUCCESSFUL!
echo ========================================
echo.
echo Next steps:
echo - Run: docker-compose up -d
echo - Access WSDL: http://localhost:8080/ws/pokemon.wsdl
echo - Access H2 Console: http://localhost:8080/h2-console
echo - Access Swagger: http://localhost:8080/swagger-ui.html
echo - Coverage Report: target/site/jacoco/index.html
echo ========================================
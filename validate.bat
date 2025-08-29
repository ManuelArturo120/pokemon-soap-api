@echo off
echo ========================================
echo Pokemon SOAP API - Validation Checklist
echo ========================================

set /a passed=0
set /a total=0

echo.
echo Checking project structure...
set /a total+=1
if exist "src\main\java\com\pokemon\api\PokemonSoapApiApplication.java" (
    echo [PASS] Main application class exists
    set /a passed+=1
) else (
    echo [FAIL] Main application class missing
)

set /a total+=1
if exist "pom.xml" (
    echo [PASS] Maven configuration exists
    set /a passed+=1
) else (
    echo [FAIL] Maven configuration missing
)

set /a total+=1
if exist "src\main\resources\pokemon.xsd" (
    echo [PASS] SOAP schema exists
    set /a passed+=1
) else (
    echo [FAIL] SOAP schema missing
)

set /a total+=1
if exist "src\test\java" (
    echo [PASS] Test directory exists
    set /a passed+=1
) else (
    echo [FAIL] Test directory missing
)

set /a total+=1
if exist "Dockerfile" (
    echo [PASS] Dockerfile exists
    set /a passed+=1
) else (
    echo [FAIL] Dockerfile missing
)

set /a total+=1
if exist "README.md" (
    echo [PASS] Documentation exists
    set /a passed+=1
) else (
    echo [FAIL] Documentation missing
)

echo.
echo ========================================
echo Validation Results: %passed%/%total% checks passed
echo ========================================

if %passed% equ %total% (
    echo [SUCCESS] All validations passed!
    echo Ready for development and deployment.
) else (
    echo [WARNING] Some validations failed.
    echo Please review the failed items above.
)
@echo off
REM Local Development Configuration Setup for Windows
REM This script sets up local development configuration for the Quantive app

echo 🔧 Setting up Local Development Configuration for Quantive App
echo ===================================================

REM Check if development config exists
if not exist "config\development.json" (
    echo ❌ Error: config\development.json not found!
    echo Please create config\development.json with your local Supabase credentials
    pause
    exit /b 1
)

echo ✅ Found development config

REM Copy development config to assets
echo 📋 Copying development config to Android assets...
if not exist "composeApp\src\androidMain\assets" mkdir "composeApp\src\androidMain\assets"
copy "config\development.json" "composeApp\src\androidMain\assets\app-config.json" >nul

echo ✅ Configuration copied to Android assets

echo.
echo 📄 Current Development Configuration:
echo ------------------------------------
type "config\development.json" | findstr /v "anonKey\|serviceRoleKey\|jwtSecret"
echo   "supabaseAnonKey": "***",
echo   "supabaseServiceRoleKey": "***",
echo   "supabaseJwtSecret": "***"
echo }

echo.
echo 🚀 Local setup complete!
echo.
echo Next steps:
echo 1. Run: gradlew.bat assembleDebug
echo 2. Install the APK on your device
echo 3. The app will use your local Supabase instance
echo.
echo 💡 Tip: Make sure your local Supabase is running at the URL specified in the config
pause
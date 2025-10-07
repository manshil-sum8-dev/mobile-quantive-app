#!/bin/bash

# Local Development Configuration Setup
# This script sets up local development configuration for the Quantive app

echo "🔧 Setting up Local Development Configuration for Quantive App"
echo "=================================================="

# Check if development config exists
if [ ! -f "config/development.json" ]; then
    echo "❌ Error: config/development.json not found!"
    echo "Please create config/development.json with your local Supabase credentials"
    exit 1
fi

echo "✅ Found development config"

# Copy development config to assets
echo "📋 Copying development config to Android assets..."
mkdir -p composeApp/src/androidMain/assets
cp config/development.json composeApp/src/androidMain/assets/app-config.json

echo "✅ Configuration copied to Android assets"

# Show the current config (with masked secrets)
echo ""
echo "📄 Current Development Configuration:"
echo "------------------------------------"
if command -v jq &> /dev/null; then
    # Use jq to format and mask secrets
    cat config/development.json | jq '{
        environment: .environment,
        supabaseUrl: .supabaseUrl,
        supabaseAnonKey: "***",
        supabaseServiceRoleKey: "***",
        supabaseJwtSecret: "***"
    }'
else
    # Fallback if jq is not available
    cat config/development.json | sed 's/"anonKey":"[^"]*"/"anonKey":"***"/' | sed 's/"serviceRoleKey":"[^"]*"/"serviceRoleKey":"***"/' | sed 's/"jwtSecret":"[^"]*"/"jwtSecret":"***"/'
fi

echo ""
echo "🚀 Local setup complete!"
echo ""
echo "Next steps:"
echo "1. Run: ./gradlew assembleDebug"
echo "2. Install the APK on your device"
echo "3. The app will use your local Supabase instance"
echo ""
echo "💡 Tip: Make sure your local Supabase is running at the URL specified in the config"
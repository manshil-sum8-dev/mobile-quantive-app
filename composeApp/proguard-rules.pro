# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep Kotlin serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt
-dontnote kotlinx.serialization.SerializationKt

-keep,includedescriptorclasses class za.co.quantive.**$$serializer { *; }
-keepclassmembers class za.co.quantive.** {
    *** Companion;
}
-keepclasseswithmembers class za.co.quantive.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# Keep Koin
-keep class org.koin.** { *; }
-dontwarn org.koin.**

# Keep SQLDelight
-keep class app.cash.sqldelight.** { *; }
-dontwarn app.cash.sqldelight.**

# Keep Ktor
-keep class io.ktor.** { *; }
-dontwarn io.ktor.**

# Keep Compose
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# Keep model classes
-keep class za.co.quantive.app.data.model.** { *; }

# Keep platform implementations
-keep class za.co.quantive.app.Platform { *; }
-keep class za.co.quantive.app.Platform* { *; }
# Room Database Search Demo - Compose Multiplatform

A simple demonstration of Room database with search functionality built using Compose Multiplatform.

## Features

- **Room Database Integration**: Uses Android Room for local data persistence
- **Real-time Search**: Search through articles by title and content using SQL LIKE queries
- **CRUD Operations**: Create, read, and delete articles
- **Modern UI**: Built with Compose Multiplatform and Material 3 design
- **Sample Data**: Pre-populated sample articles for testing search functionality

## Demo Functionality

- **Search Bar**: Type to search through article titles and content in real-time
- **Add Sample Data**: Populate the database with sample articles about Kotlin, Room, and mobile development
- **Clear All Data**: Remove all articles from the database
- **Article Cards**: Display articles with title, content preview, author, and publish date


## Before running!
 - check your system with [KDoctor](https://github.com/Kotlin/kdoctor)
 - install JDK 17 or higher on your machine
 - add `local.properties` file to the project root and set a path to Android SDK there

### Android
To run the application on android device/emulator:  
 - open project in Android Studio and run imported android run configuration

To build the application bundle:
 - run `./gradlew :composeApp:assembleDebug`
 - find `.apk` file in `composeApp/build/outputs/apk/debug/composeApp-debug.apk`

Run android UI tests on the connected device: `./gradlew :composeApp:connectedDebugAndroidTest`

### iOS
To run the application on iPhone device/simulator:
 - Open `iosApp/iosApp.xcproject` in Xcode and run standard configuration
 - Or use [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) for Android Studio

*Note: iOS support is currently limited due to Room database multiplatform setup requirements.*

Run iOS simulator UI tests: `./gradlew :composeApp:iosSimulatorArm64Test`


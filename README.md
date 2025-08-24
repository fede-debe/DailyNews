# DailyNews

An educational Kotlin Multiplatform (KMP) prototype app from the **Kotlin Multiplatform Masterclass** by Petros Efthymiou. This early-stage version offers a native Android and iOS app sharing business logic via a common KMP module.

---

## Features

- Fetches, caches, and displays top US business news using a News API.
- Shows a list of news sources utilized for data fetching.
- Includes a device info screen to display user device details.

---

## Tech Stack

- **Architecture & Patterns**: Clean Architecture, MVI (Model–View–Intent)
- **Networking**: Ktor
- **Local Data**: SQLDelight
- **DI (Dependency Injection)**: Koin
- **Android UI**: Jetpack Compose
- **iOS UI**: SwiftUI
- **Shared Module**: Kotlin Multiplatform (KMP)

---

## Project Structure

The UI layers reside in `androidApp` and `iosApp`, while the shared module—containing Business Logic, ViewModels, and Data—resides in `shared`.  
(Include architectural diagrams/screenshots here as needed.)

---

## Getting Started

1. Explore common logic located in `shared`.
2. Android and iOS implementations reside in `androidApp` and `iosApp`, respectively.

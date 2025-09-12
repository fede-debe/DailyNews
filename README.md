# DailyNews

Compose Multiplatform news app targeting **Android**, **iOS**, **Desktop (JVM)** and **Web (Wasm)**.  
One codebase, four platforms — shared Kotlin Multiplatform (KMP) business logic with Clean Architecture & MVI.

<p>
  <a href="https://kotlinlang.org/"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-Multiplatform-7F52FF?logo=kotlin&logoColor=white"></a>
  <a href="https://www.jetbrains.com/lp/compose-multiplatform/"><img alt="Compose Multiplatform" src="https://img.shields.io/badge/Compose-Multiplatform-000?logo=jetpackcompose&logoColor=white"></a>
  <a href="https://ktor.io/"><img alt="Ktor" src="https://img.shields.io/badge/Ktor-2.x-0B3D91?logo=kotlin&logoColor=white"></a>
  <a href="https://cashapp.github.io/sqldelight/"><img alt="SQLDelight" src="https://img.shields.io/badge/SQLDelight-1.x-1E88E5"></a>
  <a href="https://insert-koin.io/"><img alt="Koin" src="https://img.shields.io/badge/Koin-DI-8BC34A"></a>
</p>

## Showcase

<table>
  <tr>
    <td>
      <picture>
        <source srcset="assets/showcase/android.webp" type="image/webp">
        <img src="assets/showcase/android.gif" alt="Android demo" style="max-width:100%;height:auto;">
      </picture>
    </td>
    <td>
      <picture>
        <source srcset="assets/showcase/ios.webp" type="image/webp">
        <img src="assets/showcase/ios.gif" alt="iOS demo" style="max-width:100%;height:auto;">
      </picture>
    </td>
  </tr>
  <tr>
    <td>
      <picture>
        <source srcset="assets/showcase/desktop.webp" type="image/webp">
        <img src="assets/showcase/desktop.gif" alt="Desktop demo" style="max-width:100%;height:auto;">
      </picture>
    </td>
    <td>
      <picture>
        <source srcset="assets/showcase/web.webp" type="image/webp">
        <img src="assets/showcase/web.gif" alt="Web demo" style="max-width:100%;height:auto;">
      </picture>
    </td>
  </tr>
</table>

---

## Highlights
- **Single codebase → 4 platforms** (Android, iOS, Desktop, Web/Wasm)
- **Clean Architecture + MVI** presentation (State, Intent, Reducer)
- **Shared data layer** with Ktor (HTTP) and SQLDelight (storage)
- **Dependency Injection** via Koin
- **Compose UI** across all targets

## Project Structure
```
shared/         # KMP business logic (domain, data, MVI)
composeApp/     # Android app (Jetpack Compose)
iosApp/         # iOS host app (UIKit/SwiftUI shell + shared KMP)
desktop/        # Desktop JVM app (Compose Desktop)
web/            # Web (Wasm) app (Compose for Web/Wasm)
```

## Getting Started (very short)
- Clone the repo and open in **Android Studio** (latest stable with KMP support).
- For iOS: open `iosApp/` in Xcode to run on a simulator/device.
- For Desktop/Web: run the corresponding Gradle run configurations from the IDE.


## Tech Stack
- **Language:** Kotlin (Multiplatform)
- **UI:** Compose Multiplatform (Jetpack Compose on Android/Desktop; Compose for Web/Wasm)
- **DI:** Koin
- **Networking:** Ktor
- **Persistence:** SQLDelight

---

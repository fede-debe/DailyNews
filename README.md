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

## Showcase by platform
- [Android](#android)
- [iOS](#ios)
- [Desktop](#desktop)
- [Web](#web)

---

### Android
<div style="text-align:center;margin:0 auto;">
  <picture>
    <source srcset="assets/showcase/android.webp" type="image/webp">
    <img src="assets/showcase/android.gif"
         alt="Android demo"
         width="360"
         style="display:block;margin:0 auto;height:auto;border-radius:8px;">
  </picture>
</div>

### iOS
<div style="text-align:center;margin:0 auto;">
  <picture>
    <source srcset="assets/showcase/ios.webp" type="image/webp">
    <img src="assets/showcase/ios.gif"
         alt="iOS demo"
         width="360"
         style="display:block;margin:0 auto;height:auto;border-radius:8px;">
  </picture>
</div>

### Desktop
<div style="max-width:1100px;margin:0 auto;">
  <picture>
    <source srcset="assets/showcase/desktop.webp" type="image/webp">
    <img src="assets/showcase/desktop.gif"
         alt="Desktop demo"
         style="display:block;width:100%;height:auto;border-radius:8px;">
  </picture>
</div>

### Web
<div style="max-width:1100px;margin:0 auto;">
  <picture>
    <source srcset="assets/showcase/web.webp" type="image/webp">
    <img src="assets/showcase/web.gif"
         alt="Web demo"
         style="display:block;width:100%;height:auto;border-radius:8px;">
  </picture>
</div>


---

## Highlights
- **Single codebase → 4 platforms** (Android, iOS, Desktop, Web/Wasm)
- **Clean Architecture + MVI** presentation (State, Intent, Reducer)
- **Shared data layer** with Ktor (HTTP) and SQLDelight (storage)
- **Dependency Injection** via Koin
- **Compose UI** across all targets

## Project Structure

| Module | Platform(s) | Purpose |
|---|---|---|
| `shared/` 🧠 | All | KMP business logic — **domain**, **data**, **MVI** (state, intent, reducer) |
| `composeApp/` 🤖 | Android | Jetpack Compose app shell + DI (Koin) |
| `iosApp/` 🍎 | iOS | SwiftUI/UIKit host using the shared KMP layer |
| `desktop/` 🖥️ | Desktop (JVM) | Compose Desktop app |
| `web/` 🌐 | Web (Wasm) | Compose Multiplatform (Wasm) app |

<details>
  <summary><strong>Mini folder tree (tap to expand)</strong></summary>
  <pre><code>shared/
 ├─ domain/          # use cases, models
 ├─ data/            # repositories, Ktor, SQLDelight
 └─ presentation/    # MVI: state, intent, reducer
composeApp/
 └─ src/
iosApp/
desktop/
web/
  </code></pre>
</details>


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

# KMP Production Architecture Starter — Lite

A clean, well-structured Kotlin Multiplatform project template with proper 
architecture patterns. Perfect for learning KMP or starting a new project 
with the right foundation.

## What's Included

- ✅ Clean Architecture (data / domain / presentation)
- ✅ Ktor networking with basic setup
- ✅ Room database with example entity & DAO
- ✅ Koin dependency injection
- ✅ Compose Multiplatform UI with Material 3
- ✅ Result wrapper for error handling
- ✅ Light & Dark theme support
- ✅ Reusable UI components (Loading, Error, Empty states)

## Quick Start

### Prerequisites
- Android Studio Ladybug (2024.2.1) or later
- Xcode 16+ (for iOS, macOS only)
- JDK 17+

### Setup (5 minutes)

1. **Clone the repo**
```bash
   git clone https://github.com/Baharudin78/kmp-production-starter-lite.git
   cd kmp-production-starter-lite
```

2. **Update package name**  
   Edit `gradle.properties`:
```properties
   app.packageName=com.yourcompany.yourapp
```

3. **Open in Android Studio**  
   File → Open → select root directory

4. **Run Android**  
   Select `androidApp` configuration → Run ▶️

5. **Run iOS**  
   Open `iosApp/iosApp.xcodeproj` in Xcode → Run ▶️

## Project Structure

```text
shared/
├── data/           # API calls, DB operations, mappers
├── domain/         # Models, repository interfaces, use cases
├── presentation/   # Screens, ViewModels, UI states
├── network/        # Ktor HTTP client setup
├── database/       # Room database, entities, DAOs
└── di/             # Koin dependency injection modules
```
## Architecture

This template follows **Clean Architecture** with three layers:

1. **Presentation** — Compose screens + ViewModels + UiState
2. **Domain** — Use cases + repository interfaces + domain models
3. **Data** — Repository implementations + API + Database + Mappers

Data flows one direction: **UI → ViewModel → UseCase → Repository → API/DB**

## Result Wrapper

All operations return a typed `Result`:
```kotlin
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: AppException) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}
```

## Want More?

This is the **Lite** version. For production features, check out:

- ⭐ **[Pro ($39)]** — Multi-module, offline-first sync, Paging 3, 
  convention plugins, 401 token refresh
- 🏢 **[Enterprise ($79)]** — Pro + biometric auth, SSL pinning, 
  CI/CD, build variants, video walkthrough

→ [Get Pro/Enterprise on Gumroad](https://yourname.gumroad.com/l/kmp-starter)

## License

MIT License — use for any project, commercial or personal.

## Contributing

PRs welcome! Please open an issue first to discuss changes.

## Star ⭐

If this template saved you time, please give it a star! 
It helps other developers find this project.

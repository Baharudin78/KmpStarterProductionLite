# KMP Production Architecture Starter — LITE (Free)

## 🆓 Lite Tier — Open Source on GitHub

**Tagline:** *A clean starting point for Kotlin Multiplatform projects with proper architecture.*

---

## Directory Structure

```
kmp-production-starter-lite/
│
├── shared/                               # Shared KMP module
│   ├── build.gradle.kts
│   └── src/
│       ├── commonMain/kotlin/
│       │   ├── util/
│       │   │   ├── Result.kt              # Sealed Result wrapper (Success/Error/Loading)
│       │   │   ├── AppException.kt        # Typed exceptions (Unauthorized, NoInternet, Server)
│       │   │   └── Extensions.kt          # Common extension functions
│       │   │
│       │   ├── network/
│       │   │   ├── HttpClientFactory.kt   # Basic Ktor client (logging + content negotiation)
│       │   │   ├── ApiResponse.kt         # Generic API response wrapper
│       │   │   └── ApiError.kt            # Error model
│       │   │
│       │   ├── database/
│       │   │   ├── AppDatabase.kt         # Room database definition (single entity example)
│       │   │   ├── DatabaseFactory.kt     # expect/actual database builder
│       │   │   └── entity/
│       │   │       └── ItemEntity.kt      # Example entity
│       │   │
│       │   ├── di/
│       │   │   └── SharedModule.kt        # Koin module (network + database)
│       │   │
│       │   ├── data/
│       │   │   ├── repository/
│       │   │   │   └── ItemRepositoryImpl.kt
│       │   │   ├── remote/
│       │   │   │   ├── ItemApi.kt         # Ktor API service
│       │   │   │   └── dto/
│       │   │   │       └── ItemDto.kt
│       │   │   ├── local/
│       │   │   │   └── dao/
│       │   │   │       └── ItemDao.kt     # Room DAO
│       │   │   └── mapper/
│       │   │       └── ItemMapper.kt      # DTO ↔ Entity ↔ Domain
│       │   │
│       │   ├── domain/
│       │   │   ├── model/
│       │   │   │   └── Item.kt            # Domain model
│       │   │   ├── repository/
│       │   │   │   └── ItemRepository.kt  # Repository interface
│       │   │   └── usecase/
│       │   │       └── GetItemsUseCase.kt
│       │   │
│       │   └── presentation/
│       │       ├── items/
│       │       │   ├── ItemsScreen.kt
│       │       │   ├── ItemsViewModel.kt
│       │       │   └── ItemsUiState.kt
│       │       └── theme/
│       │           ├── AppTheme.kt        # Material 3 theme (light + dark)
│       │           ├── Color.kt
│       │           └── Typography.kt
│       │
│       ├── androidMain/kotlin/
│       │   └── database/
│       │       └── DatabaseFactory.android.kt
│       └── iosMain/kotlin/
│           └── database/
│               └── DatabaseFactory.ios.kt
│
├── composeApp/                           # Compose Multiplatform entry
│   ├── build.gradle.kts
│   └── src/
│       ├── commonMain/kotlin/
│       │   ├── App.kt                    # Root composable
│       │   ├── navigation/
│       │   │   └── AppNavGraph.kt        # Simple navigation setup
│       │   └── component/
│       │       ├── LoadingIndicator.kt
│       │       ├── ErrorDialog.kt
│       │       └── EmptyState.kt
│       ├── androidMain/kotlin/
│       │   └── MainApplication.kt
│       └── iosMain/kotlin/
│           └── MainViewController.kt
│
├── androidApp/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       └── kotlin/.../MainActivity.kt
│
├── iosApp/
│   ├── iosApp.xcodeproj/
│   └── iosApp/
│       ├── ContentView.swift
│       └── iOSApp.swift
│
├── gradle/
│   ├── libs.versions.toml                # Version catalog
│   └── wrapper/
│
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── README.md
├── LICENSE                               # MIT License
└── .gitignore
```

---

## Architecture Diagram

```
┌──────────────────────────────────────────┐
│              composeApp                   │
│         (Entry Point + Nav)              │
└──────────────────┬───────────────────────┘
                   │
┌──────────────────▼───────────────────────┐
│                shared/                    │
│                                          │
│  ┌─────────────────────────────────────┐ │
│  │          presentation/              │ │
│  │   ItemsScreen → ItemsViewModel      │ │
│  │              → ItemsUiState         │ │
│  └──────────────┬──────────────────────┘ │
│                 │                         │
│  ┌──────────────▼──────────────────────┐ │
│  │            domain/                  │ │
│  │   GetItemsUseCase                   │ │
│  │   ItemRepository (interface)        │ │
│  │   Item (domain model)              │ │
│  └──────────────┬──────────────────────┘ │
│                 │                         │
│  ┌──────────────▼──────────────────────┐ │
│  │             data/                   │ │
│  │   ItemRepositoryImpl               │ │
│  │   ItemApi (Ktor) ←→ ItemDao (Room) │ │
│  │   ItemMapper (DTO ↔ Entity ↔ Model)│ │
│  └─────────────────────────────────────┘ │
│                                          │
│  ┌────────┐  ┌──────────┐  ┌──────────┐ │
│  │network │  │ database │  │   di/    │ │
│  │  Ktor  │  │   Room   │  │  Koin   │ │
│  └────────┘  └──────────┘  └──────────┘ │
└──────────────────────────────────────────┘
```

---

## Tech Stack

| Layer | Library |
|-------|---------|
| UI | Compose Multiplatform + Material 3 |
| Navigation | Jetpack Navigation Compose |
| Networking | Ktor Client |
| DI | Koin |
| Local DB | Room (KMP) |
| Async | Kotlinx Coroutines + Flow |
| Serialization | Kotlinx Serialization |
| Logging | Napier |

---

## README.md

```markdown
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
   git clone https://github.com/yourname/kmp-production-starter-lite.git
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

```
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
```

---

## Key Features Explained

### Result Wrapper (util/Result.kt)
```kotlin
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: AppException) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}

sealed class AppException(override val message: String) : Exception(message) {
    data object Unauthorized : AppException("Session expired")
    data object NoInternet : AppException("No internet connection")
    data class Server(override val message: String) : AppException(message)
    data class Unknown(override val message: String) : AppException(message)
}
```

### Basic Ktor Setup (network/HttpClientFactory.kt)
```kotlin
fun createHttpClient(): HttpClient {
    return HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.d(message, tag = "HTTP")
                }
            }
            level = LogLevel.BODY
        }
        defaultRequest {
            url("https://your-api.com/api/v1/")
            contentType(ContentType.Application.Json)
        }
    }
}
```

### Simple ViewModel Pattern
```kotlin
class ItemsViewModel(
    private val getItemsUseCase: GetItemsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ItemsUiState())
    val uiState: StateFlow<ItemsUiState> = _uiState.asStateFlow()

    fun loadItems() {
        viewModelScope.launch {
            _uiState.update { it.copy(result = Result.Loading) }
            val result = getItemsUseCase()
            _uiState.update { it.copy(result = result) }
        }
    }
}

data class ItemsUiState(
    val result: Result<List<Item>> = Result.Loading
)
```

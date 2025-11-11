
# BVG-Android

BVG Transport is a **native Android app** built with **Jetpack Compose** that allows users to search for BVG stops in Berlin and view upcoming departures in real-time. It uses the **BVG Open API** to fetch locations and departures.

---

## **Features**

- Search for BVG stops by name.
- View the next departures for a selected stop.
- Departure times are displayed in **minutes from now**.
- Displays delay information if available.
- Simple, clean UI using **Jetpack Compose** and **Material3**.
- Navigation between screens using **Navigation Compose**.

---

## **Screens**

1. **Stop Search Screen**
    - Search for stops using a query.
    - Click on a stop to view departures.

2. **Departures Screen**
    - Displays upcoming departures in a list.
    - Shows line, direction, minutes until departure, and delay.
    - Back button to return to search.

---

## **Tech Stack**

- **Language:** Kotlin
- **UI:** Jetpack Compose (Material3)
- **Navigation:** Navigation Compose
- **Networking:** Retrofit + OkHttp + Gson
- **Coroutines:** Kotlin Coroutines for async network calls
- **State Management:** StateFlow in ViewModel
- **Minimum SDK:** 24

---

## **Setup Instructions**

1. Clone the repository:

```bash
git clone https://github.com/muneebjan/BVG-Android
```

2. Open the project in **Android Studio (Electric Eel or newer)**.
3. Make sure **Gradle dependencies are synced**.

4. Run the app on an emulator or real device.

---

## **Dependencies**

- Retrofit2 + Gson Converter
- OkHttp Logging Interceptor
- Kotlin Coroutines
- AndroidX Core KTX, Lifecycle, ViewModel Compose
- Navigation Compose
- Jetpack Compose UI + Material3

Dependencies are managed via **Gradle version catalog**.

---

## **Project Structure**

```
app/
 ├─ src/main/java/com/example/bvgnativ/
 │   ├─ data/
 │   │   ├─ api/          # Retrofit interfaces & API client
 │   │   ├─ model/        # Data models (Stop, Departure, DeparturesResponse)
 │   │   └─ repository/   # Repository for API calls
 │   ├─ screens/          # Composable screens
 │   ├─ viewmodel/        # MainViewModel.kt
 │   └─ MainActivity.kt   # Entry point
 └─ build.gradle.kts
```

---

## **API Used**

- Base URL: `https://v6.bvg.transport.rest`
- Endpoints:
    - `/locations` — Search stops by query
    - `/stops/{stopId}/departures` — Get next departures at a stop

---

## **Future Improvements**

- Add favorite stops.
- Show platform numbers if available.
- Improve UI with icons for bus, subway, tram.
- Offline caching for last fetched departures.

---

## **License**

This project is open-source under the MIT License.

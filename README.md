# Ktor Movie Application

This is a sample Android application that demonstrates how to use Ktor for network operations in an Android app. The app fetches popular movies from a remote API and displays them in a list.

## Features

- Fetches popular movies from a remote API using Ktor.
- Displays a list of movies using a ViewModel and RecyclerView.
- Implements dependency injection with Dagger Hilt.
- Handles API responses and errors gracefully.

## Architecture

- **MVVM (Model-View-ViewModel)**: Used for managing UI-related data.
- **Ktor**: For making network requests.
- **Dagger Hilt**: For dependency injection.
- **Kotlinx Serialization**: For JSON serialization.

## Project Structure

- `data/models/`: Contains data models for movie data.
- `data/network/`: Contains network client configuration and resource classes.
- `data/repository/`: Contains repository implementations for fetching movie data.
- `di/`: Contains Dagger Hilt modules for dependency injection.
- `ui/`: Contains activities and recycler view adapters
- `viewmodels/`: Contains ViewModels for managing UI-related data.


# ToDoApp

A simple Android task manager app built with Clean Architecture and MVVM.

## Features

- Add, delete and complete tasks
- Persistent local storage
- Dark/Light theme support

## Tech Stack

- **Kotlin** 2.0.21
- **Jetpack Compose** (Material 3)
- **Room** (Database)
- **Hilt** (Dependency Injection)
- **Coroutines** + **Flow**

## Architecture

Clean Architecture with 4 layers:
- **presentation** - UI & ViewModels
- **domain** - Business logic & use cases
- **data** - Repository implementations & data sources
- **di** - Dependency injection modules

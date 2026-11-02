# Activity Tracker

A JavaFX desktop application for tracking daily activities, monitoring time spent, and analyzing productivity patterns. Designed for personal use, the app helps users log activities such as studying, exercise, reading, and work sessions while keeping a historical record in a CSV file.

## Overview

Activity Tracker provides a simple and intuitive interface to:

- record activities with a name, duration, and date
- maintain a personal history of activities
- save and reload records from a local CSV file
- view summaries and insights about total time and frequency

The application is ideal for users who want a lightweight productivity tool without the complexity of a larger database-backed system.

## Features

- Add activities with custom names and duration in minutes
- Select the date for each activity entry
- Store all records locally in a CSV file
- Load previous activity data from the file
- Analyze the most frequent activity
- View total time spent per activity
- Review daily summaries and aggregated data
- Clear the current table view with confirmation
- Clean JavaFX desktop interface for easy daily usage

## Technology Stack

- Java
- JavaFX
- CSV file-based persistence

## Project Structure

```text
Activity-tracker/
├── MainApp.java
├── Activity.java
├── Analytics.java
├── FileHandler.java
├── activities.csv
├── README.md
└── out/
```

### File Descriptions

- `MainApp.java` – JavaFX application logic and user interface
- `Activity.java` – model class for activity records
- `Analytics.java` – methods for calculating summaries and analytics
- `FileHandler.java` – CSV read/write operations
- `activities.csv` – stored activity records

## Prerequisites

Before running the project, ensure you have:

- Java JDK 17 or later
- JavaFX SDK configured on your machine
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code, or the command-line Java toolchain

## Setup

1. Clone the repository:

```bash
git clone https://github.com/aklilut40-code/Activity-tracker.git
cd Activity-tracker
```

2. Ensure JavaFX is installed and available in your environment.

3. Set the JavaFX module path to your local JavaFX `lib` directory.

## Running the Application

Compile and run the project from the terminal:

```bash
mkdir -p out
javac --module-path "$PATH_TO_FX" --add-modules javafx.controls,javafx.fxml -d out $(find . -name "*.java")
java --module-path "$PATH_TO_FX" --add-modules javafx.controls,javafx.fxml -cp out activitytracker.MainApp
```

Replace `$PATH_TO_FX` with the actual path to your JavaFX installation, for example:

```bash
export PATH_TO_FX=/path/to/javafx-sdk/lib
```

## Usage

1. Open the application.
2. Enter the activity name.
3. Enter the duration in minutes.
4. Select the date.
5. Click `ADD ACTIVITY`.
6. Use `SAVE TO FILE` to persist the entries.
7. Use `LOAD FROM FILE` to read saved records.
8. Use `ANALYZE DATA` to view summaries and analytics.

## Data Format

The app stores activity records in `activities.csv` using the following format:

```csv
Studying,45,2026-11-01
Exercise,30,2026-11-01
Reading,20,2026-11-02
```

Each row contains:

- activity name
- duration in minutes
- date in `yyyy-MM-dd` format

## Example Analytics

The analytics module supports calculations such as:

- total minutes spent per activity
- most frequent activity
- daily summary totals
- weekly summary totals
- average duration per activity

## Project Goals

This project demonstrates practical Java development concepts, including:

- GUI development with JavaFX
- object-oriented design
- file handling and CSV persistence
- data analysis in Java
- application state management

## License

This project is provided for educational and personal use. If you plan to distribute or modify it for public use, please check whether a specific license is required by your institution or organization.

## Future Improvements

Potential enhancements for a future version include:

- category-based activity filtering
- charts and visual analytics
- database persistence instead of CSV
- user authentication and profile management
- export to PDF or Excel
- search and sorting improvements

# Activity Tracker

Activity Tracker is a JavaFX desktop application designed to help you log, save, and analyze the activities you do each day. It is a simple personal productivity tool for tracking exercises, study sessions, reading time, and other daily habits.

## Features

- Add a new activity with a name, duration, and date
- View all logged activities in a table
- Save activities to a CSV file
- Load previously saved activities from file
- Analyze activity trends with built-in summaries
- Clear the current list after confirmation

## Project Structure

- `MainApp.java` – JavaFX user interface and app logic
- `Activity.java` – Activity model with CSV conversion helpers
- `Analytics.java` – summary and statistics calculations
- `FileHandler.java` – CSV reading and writing utilities

## Example Activity Data

The app stores data in a CSV file named `activities.csv` with rows in this format:

```csv
Studying,45,2026-11-01
Exercise,30,2026-11-01
Reading,20,2026-11-02
```

## Requirements

- Java JDK 17 or later
- JavaFX SDK
- An IDE such as IntelliJ IDEA or VS Code, or command-line compilation

## Running the Application

From the project root, compile and run the app with JavaFX on your system.

```bash
mkdir -p out
javac --module-path "$PATH_TO_FX" --add-modules javafx.controls,javafx.fxml -d out $(find . -name "*.java")
java --module-path "$PATH_TO_FX" --add-modules javafx.controls,javafx.fxml -cp out activitytracker.MainApp
```

Replace `$PATH_TO_FX` with the path to your JavaFX `lib` directory.

## Usage

1. Enter an activity name.
2. Enter the duration in minutes.
3. Select the date.
4. Click `ADD ACTIVITY`.
5. Use the buttons to save, load, and analyze your records.

## Notes

This project is a lightweight personal tracker and is ideal for learning JavaFX GUI development, file handling, and basic data analysis in Java.

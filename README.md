# 📊 Activity Tracker

<p align="center">
  <img src="https://images.unsplash.com/photo-1516321497487-e288fb19713f?auto=format&fit=crop&w=1200&q=80" alt="Activity Tracker Banner" width="100%" />
</p>

<p align="center">
  <a href="#overview"><img src="https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=java" alt="Java 17+" /></a>
  <a href="#technology-stack"><img src="https://img.shields.io/badge/JavaFX-Desktop-FF7F50?style=for-the-badge" alt="JavaFX" /></a>
  <a href="#license"><img src="https://img.shields.io/badge/License-Educational-4B5563?style=for-the-badge" alt="License" /></a>
  <a href="#status"><img src="https://img.shields.io/badge/Status-Active-22C55E?style=for-the-badge" alt="Status" /></a>
</p>

---

## 🧭 Overview

Activity Tracker is a JavaFX desktop application designed to help users track daily activities, monitor how much time they spend on each task, and review productivity trends over time. The app supports personal habit tracking for activities such as studying, exercising, reading, and work-related routines.

This project is ideal for managing time effectively while also serving as a practical example of Java GUI development, file persistence, and basic data analysis.

---

## ✨ Features

<div align="center">

| Feature | Description |
| --- | --- |
| 📝 Activity Logging | Add activities with a name, duration, and date |
| 📊 Analytics Dashboard | View most frequent activities and total time spent |
| 💾 File Persistence | Save and reload data using a CSV file |
| 📅 Daily Summaries | Track time spent by date |
| 🧠 Productivity Insights | Analyze patterns in your personal routine |
| 🖥️ JavaFX UI | Clean desktop interface for fast daily use |

</div>

---

## 🏗️ Technology Stack

- Java 17+
- JavaFX for the GUI
- CSV-based local persistence
- OOP structure with modular classes for analytics and file handling

---

## 📁 Project Structure

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

- `MainApp.java` – JavaFX application and interface logic
- `Activity.java` – model class for activity records
- `Analytics.java` – summary and productivity calculation methods
- `FileHandler.java` – CSV read/write utilities
- `activities.csv` – stored user activity data

---

## ✅ Prerequisites

Before running the project, ensure you have:

- Java JDK 17 or later
- JavaFX SDK installed and configured
- IntelliJ IDEA, Eclipse, or VS Code with Java support

---

## ⚙️ Setup and Run

### 1) Clone the repository

```bash
git clone https://github.com/aklilut40-code/Activity-tracker.git
cd Activity-tracker
```

### 2) Set JavaFX path

```bash
export PATH_TO_FX=/path/to/javafx-sdk/lib
```

### 3) Compile and run

```bash
mkdir -p out
javac --module-path "$PATH_TO_FX" --add-modules javafx.controls,javafx.fxml -d out $(find . -name "*.java")
java --module-path "$PATH_TO_FX" --add-modules javafx.controls,javafx.fxml -cp out activitytracker.MainApp
```

---

## 🧪 Usage

1. Enter an activity name.
2. Input the duration in minutes.
3. Select the date.
4. Click `ADD ACTIVITY`.
5. Save your records using `SAVE TO FILE`.
6. Load prior records with `LOAD FROM FILE`.
7. Open the analytics panel to review insights.

---

## 📄 Data Format

The application stores activity data in `activities.csv` using the following format:

```csv
Studying,45,2026-11-01
Exercise,30,2026-11-01
Reading,20,2026-11-02
```

Each row contains:

- activity name
- duration in minutes
- date in `yyyy-MM-dd` format

---

## 📊 Analytics Included

The project includes logic for:

- total time spent per activity
- most frequent activity
- daily time summaries
- weekly summaries
- average duration per activity

---

## 🧭 Project Status

This project is currently active and functional as a JavaFX activity tracking app for personal productivity and learning.

---

## 📝 License

This project is provided for educational and personal use. If you plan to distribute or modify it publicly, verify whether a formal license is required by your institution or organization.

---

## 🌱 Future Improvements

Possible future enhancements include:

- activity categories and filters
- charts and visual dashboards
- database-backed storage
- advanced export features
- weekly and monthly reporting
- user profile support

---

<p align="center">
  <strong>Built with JavaFX to make daily habit tracking simple and effective.</strong>
</p>

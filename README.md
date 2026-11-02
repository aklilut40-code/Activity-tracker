# 📊 Activity Tracker

<p align="center">
  <img src="https://images.unsplash.com/photo-1516321318423-f06f85e504b3?auto=format&fit=crop&w=1400&q=80" alt="Activity Tracker Banner" width="100%" />
</p>

<p align="center">
  <a href="#overview"><img src="https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=java" alt="Java 17+" /></a>
  <a href="#technology-stack"><img src="https://img.shields.io/badge/JavaFX-Desktop-FF7F50?style=for-the-badge" alt="JavaFX" /></a>
  <a href="#license"><img src="https://img.shields.io/badge/License-Educational-4B5563?style=for-the-badge" alt="License" /></a>
  <a href="#status"><img src="https://img.shields.io/badge/Status-Active-22C55E?style=for-the-badge" alt="Status" /></a>
</p>

<p align="center">
  <strong>Track your daily activities, monitor your time, and turn routine into measurable progress.</strong>
</p>

---

## 🧭 Overview

Activity Tracker is a JavaFX desktop application designed to help users log daily activities, analyze time usage, and uncover productivity patterns. It is a lightweight and practical tool for personal habit tracking, whether you want to monitor study time, exercise routines, reading sessions, or work-related tasks.

The project combines an intuitive graphical interface with CSV-based persistence and built-in analytics, making it a strong example of practical Java development for real-world productivity needs.

---

## ✨ Why This Project?

- Simple, clean interface for daily usage
- Lightweight desktop app with no external database required
- Helps users understand how time is spent
- Great project for learning JavaFX, file handling, and analytics
- Easy to extend with new features and reporting tools

---

## 🚀 Key Features

<div align="center">

| Feature | Description |
| --- | --- |
| 📝 Activity Logging | Add activities with a custom name, duration, and date |
| 📊 Analytics Dashboard | Review total time, frequency, and daily summaries |
| 💾 Persistent Storage | Save and reload records from a local CSV file |
| 📅 Time Tracking | Track how much time you devote to each activity |
| 🧠 Productivity Insights | Identify your most frequent and most time-consuming routines |
| 🖥️ JavaFX Interface | A polished desktop experience for daily tracking |

</div>

---

## 🏗️ Technology Stack

- Java 17+
- JavaFX
- CSV file-based persistence
- Object-oriented application design

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

### File Overview

- `MainApp.java` – JavaFX interface and workflow logic
- `Activity.java` – activity data model with conversion helpers
- `Analytics.java` – summary and calculation logic
- `FileHandler.java` – CSV read and write operations
- `activities.csv` – saved user activity records

---

## 🖼️ App Preview

<p align="center">
  <img src="https://images.unsplash.com/photo-1552664730-d307ca884978?auto=format&fit=crop&w=1200&q=80" alt="Project Interface Preview" width="80%" />
</p>

This project is designed to give users a straightforward dashboard for recording and reviewing activity history with minimal friction.

---

## ✅ Prerequisites

Before running the project, ensure you have:

- Java JDK 17 or later
- JavaFX SDK installed and configured
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code

---

## ⚙️ Setup and Run

### 1) Clone the repository

```bash
git clone https://github.com/aklilut40-code/Activity-tracker.git
cd Activity-tracker
```

### 2) Set your JavaFX path

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

## 🧪 How to Use

1. Open the application.
2. Enter the activity name.
3. Enter the time in minutes.
4. Select the date.
5. Click `ADD ACTIVITY`.
6. Save your entries using `SAVE TO FILE`.
7. Load records with `LOAD FROM FILE`.
8. Open `ANALYZE DATA` for summaries and insights.

---

## 📄 Data Format

The application stores data in `activities.csv` using the following structure:

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

The app includes built-in functionality for:

- total minutes spent per activity
- most frequent activity
- daily summary totals
- weekly summary totals
- average duration per activity

---

## 🧭 Status

This project is currently active and serves as a functional JavaFX productivity tracker for personal use and learning.

---

## 📝 License

This project is intended for educational and personal use. If you plan to distribute or modify it publicly, please review whether a formal license is required by your institution or organization.

---

## 🌱 Future Enhancements

Potential improvements include:

- category-based activity filtering
- visual charts and reporting
- database-backed storage
- search and sorting tools
- export to CSV, PDF, or Excel
- monthly and yearly summaries
- user profile management

---

<p align="center">
  <strong>Built to make daily activity tracking simple, effective, and insightful.</strong>
</p>

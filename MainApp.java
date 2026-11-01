package activitytracker;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MainApp extends Application {
    
    private TableView<Activity> tableView;
    private ObservableList<Activity> activityList;
    
    private TextField nameField;
    private TextField durationField;
    private DatePicker datePicker;
    private Label statusLabel;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("✨ Personal Activity Tracker ✨");
        primaryStage.setWidth(1200);
        primaryStage.setHeight(700);
        
        // Main layout with gradient background
        BorderPane mainLayout = new BorderPane();
        mainLayout.setStyle("-fx-background: linear-gradient(to bottom right, #f0f4f8, #d9e2ec);");
        mainLayout.setPadding(new Insets(15));
        
        // Create top header
        VBox header = createHeader();
        mainLayout.setTop(header);
        
        // Create center with VERTICAL separation (LEFT = Input, RIGHT = Table)
        HBox centerContent = createCenterWithVerticalSeparator();
        mainLayout.setCenter(centerContent);
        
        // Create bottom status bar
        VBox bottomPanel = createBottomStatusPanel();
        mainLayout.setBottom(bottomPanel);
        
        // Load existing data
        loadDataFromFile();
        
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private VBox createHeader() {
        VBox header = new VBox(10);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10, 0, 20, 0));
        
        Label titleLabel = new Label("📊 PERSONAL ACTIVITY TRACKER 📊");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        titleLabel.setStyle("-fx-text-fill: #2c3e50;");
        
        Label subtitleLabel = new Label("Track, Analyze, and Improve Your Daily Activities");
        subtitleLabel.setFont(Font.font("Arial", 16));
        subtitleLabel.setStyle("-fx-text-fill: #7f8c8d; -fx-font-style: italic;");
        
        header.getChildren().addAll(titleLabel, subtitleLabel);
        return header;
    }
    
    private HBox createCenterWithVerticalSeparator() {
        HBox centerBox = new HBox(20);
        centerBox.setAlignment(Pos.CENTER);
        
        // LEFT SIDE - Input Panel (Add Activity form)
        VBox leftPanel = createLeftInputPanel();
        leftPanel.setPrefWidth(350);
        
        // VERTICAL SEPARATOR (vertical line between left and right)
        Separator verticalSeparator = new Separator();
        verticalSeparator.setOrientation(javafx.geometry.Orientation.VERTICAL);
        verticalSeparator.setStyle("-fx-background-color: #3498db; -fx-pref-width: 3;");
        verticalSeparator.setPrefHeight(500);
        
        // RIGHT SIDE - Activity History Table
        VBox rightPanel = createRightTablePanel();
        rightPanel.setPrefWidth(700);
        
        centerBox.getChildren().addAll(leftPanel, verticalSeparator, rightPanel);
        return centerBox;
    }
    
    private VBox createLeftInputPanel() {
        VBox panel = new VBox(15);
        panel.setPadding(new Insets(20));
        panel.setStyle("-fx-background-color: white; -fx-border-radius: 15; -fx-background-radius: 15; " +
                      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 5);");
        
        Label sectionTitle = new Label("📝 ADD NEW ACTIVITY");
        sectionTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        sectionTitle.setStyle("-fx-text-fill: #2c3e50;");
        
        // Activity Name
        Label nameLabel = new Label("🏷️ Activity Name:");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        nameLabel.setStyle("-fx-text-fill: #34495e;");
        
        nameField = new TextField();
        nameField.setPromptText("e.g., Studying, Exercise, Reading");
        nameField.setFont(Font.font("Arial", 14));
        nameField.setStyle("-fx-padding: 10; -fx-background-radius: 8; -fx-border-radius: 8; " +
                          "-fx-border-color: #bdc3c7; -fx-border-width: 1.5;");
        
        // Duration
        Label durationLabel = new Label("⏱️ Duration (minutes):");
        durationLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        durationLabel.setStyle("-fx-text-fill: #34495e;");
        
        durationField = new TextField();
        durationField.setPromptText("e.g., 45");
        durationField.setFont(Font.font("Arial", 14));
        durationField.setStyle("-fx-padding: 10; -fx-background-radius: 8; -fx-border-radius: 8; " +
                              "-fx-border-color: #bdc3c7; -fx-border-width: 1.5;");
        
        // Date
        Label dateLabel = new Label("📅 Date:");
        dateLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        dateLabel.setStyle("-fx-text-fill: #34495e;");
        
        datePicker = new DatePicker(LocalDate.now());
        datePicker.setStyle("-fx-font-size: 14px; -fx-font-family: Arial; -fx-padding: 8; " +
                           "-fx-background-radius: 8; -fx-border-radius: 8;");
        
        // Add button
        Button addButton = createStyledButton("➕ ADD ACTIVITY", "#27ae60", "#2ecc71");
        addButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        addButton.setMaxWidth(Double.MAX_VALUE);
        addButton.setOnAction(e -> addActivity());
        
        // Action buttons section
        Label actionTitle = new Label("⚡ ACTIONS");
        actionTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        actionTitle.setStyle("-fx-text-fill: #2c3e50; -fx-padding: 20 0 0 0;");
        
        Button saveButton = createStyledButton("💾 SAVE TO FILE", "#3498db", "#5dade2");
        saveButton.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        saveButton.setMaxWidth(Double.MAX_VALUE);
        saveButton.setOnAction(e -> saveToFile());
        
        Button loadButton = createStyledButton("📂 LOAD FROM FILE", "#f39c12", "#f1c40f");
        loadButton.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        loadButton.setMaxWidth(Double.MAX_VALUE);
        loadButton.setOnAction(e -> loadDataFromFile());
        
        Button analyzeButton = createStyledButton("📊 ANALYZE DATA", "#9b59b6", "#af7ac5");
        analyzeButton.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        analyzeButton.setMaxWidth(Double.MAX_VALUE);
        analyzeButton.setOnAction(e -> showAnalytics());
        
        Button clearButton = createStyledButton("🗑️ CLEAR ALL", "#e74c3c", "#ec7063");
        clearButton.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        clearButton.setMaxWidth(Double.MAX_VALUE);
        clearButton.setOnAction(e -> clearAll());
        
        panel.getChildren().addAll(
            sectionTitle, nameLabel, nameField, 
            durationLabel, durationField, dateLabel, datePicker, addButton,
            actionTitle, saveButton, loadButton, analyzeButton, clearButton
        );
        
        return panel;
    }
    
    private VBox createRightTablePanel() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(20));
        panel.setStyle("-fx-background-color: white; -fx-border-radius: 15; -fx-background-radius: 15; " +
                      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 5);");
        
        Label tableTitle = new Label("📋 ACTIVITY HISTORY");
        tableTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        tableTitle.setStyle("-fx-text-fill: #2c3e50;");
        
        createTableView();
        tableView.setStyle("-fx-font-size: 13px;");
        
        panel.getChildren().addAll(tableTitle, tableView);
        return panel;
    }
    
    private void createTableView() {
        tableView = new TableView<>();
        activityList = FXCollections.observableArrayList();
        
        TableColumn<Activity, String> nameCol = new TableColumn<>("🏷️ Activity Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(250);
        nameCol.setStyle("-fx-font-size: 13px; -fx-font-weight: bold;");
        
        TableColumn<Activity, Integer> durationCol = new TableColumn<>("⏱️ Duration (min)");
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        durationCol.setPrefWidth(150);
        durationCol.setStyle("-fx-font-size: 13px;");
        
        TableColumn<Activity, LocalDate> dateCol = new TableColumn<>("📅 Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateCol.setPrefWidth(150);
        dateCol.setStyle("-fx-font-size: 13px;");
        
        tableView.getColumns().addAll(nameCol, durationCol, dateCol);
        tableView.setItems(activityList);
        tableView.setStyle("-fx-background-color: transparent;");
    }
    
    private VBox createBottomStatusPanel() {
        VBox panel = new VBox(5);
        panel.setPadding(new Insets(10, 0, 5, 0));
        
        statusLabel = new Label("✅ Ready to track your activities");
        statusLabel.setFont(Font.font("Arial", 12));
        statusLabel.setStyle("-fx-text-fill: #7f8c8d;");
        
        panel.getChildren().add(statusLabel);
        return panel;
    }
    
    private Button createStyledButton(String text, String color1, String color2) {
        Button button = new Button(text);
        button.setStyle(
            "-fx-background-color: linear-gradient(to bottom, " + color2 + ", " + color1 + ");" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 10 15 10 15;" +
            "-fx-background-radius: 25;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0, 0, 2);"
        );
        
        button.setOnMouseEntered(e -> 
            button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, " + color1 + ", " + color2 + ");" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 15 10 15;" +
                "-fx-background-radius: 25;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 3);"
            )
        );
        
        button.setOnMouseExited(e -> 
            button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, " + color2 + ", " + color1 + ");" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 15 10 15;" +
                "-fx-background-radius: 25;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0, 0, 2);"
            )
        );
        
        return button;
    }
    
    private void addActivity() {
        try {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                showAlert("Error", "Please enter an activity name");
                return;
            }
            
            int duration;
            try {
                duration = Integer.parseInt(durationField.getText().trim());
                if (duration <= 0) {
                    showAlert("Error", "Duration must be positive");
                    return;
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Please enter a valid number for duration");
                return;
            }
            
            LocalDate date = datePicker.getValue();
            if (date == null) {
                date = LocalDate.now();
            }
            
            Activity activity = new Activity(name, duration, date);
            activityList.add(activity);
            
            nameField.clear();
            durationField.clear();
            datePicker.setValue(LocalDate.now());
            
            statusLabel.setText("✅ Activity added successfully!");
            statusLabel.setStyle("-fx-text-fill: #27ae60; -fx-font-weight: bold;");
            
            new Thread(() -> {
                try { Thread.sleep(3000); } catch (InterruptedException e) {}
                javafx.application.Platform.runLater(() -> {
                    statusLabel.setText("✅ Ready to track your activities");
                    statusLabel.setStyle("-fx-text-fill: #7f8c8d;");
                });
            }).start();
            
        } catch (Exception e) {
            showAlert("Error", "Failed to add activity: " + e.getMessage());
        }
    }
    
    private void saveToFile() {
        try {
            for (Activity activity : activityList) {
                FileHandler.appendActivity(activity);
            }
            statusLabel.setText("💾 Data saved to activities.csv successfully!");
            statusLabel.setStyle("-fx-text-fill: #3498db; -fx-font-weight: bold;");
            showAlert("Success", "✅ Data saved to activities.csv");
        } catch (IOException e) {
            showAlert("Error", "Failed to save: " + e.getMessage());
        }
    }
    
    private void loadDataFromFile() {
        try {
            List<Activity> activities = FileHandler.loadActivities();
            activityList.clear();
            activityList.addAll(activities);
            statusLabel.setText("📂 Loaded " + activities.size() + " activities from file");
            statusLabel.setStyle("-fx-text-fill: #f39c12; -fx-font-weight: bold;");
        } catch (IOException e) {
            showAlert("Error", "Failed to load: " + e.getMessage());
        }
    }
    
    private void showAnalytics() {
        if (activityList.isEmpty()) {
            showAlert("No Data", "Please add or load some activities first");
            return;
        }
        
        Stage analyticsStage = new Stage();
        analyticsStage.setTitle("📊 Analytics Dashboard");
        analyticsStage.setWidth(600);
        analyticsStage.setHeight(700);
        
        VBox analyticsLayout = new VBox(15);
        analyticsLayout.setPadding(new Insets(20));
        analyticsLayout.setStyle("-fx-background: linear-gradient(to bottom, #f0f4f8, #e8eef4);");
        
        Label title = new Label("📈 ACTIVITY ANALYTICS DASHBOARD");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title.setStyle("-fx-text-fill: #2c3e50;");
        
        String mostFrequent = Analytics.getMostFrequentActivity(activityList);
        Label frequentLabel = new Label("⭐ MOST FREQUENT ACTIVITY: " + mostFrequent);
        frequentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        frequentLabel.setStyle("-fx-text-fill: #9b59b6; -fx-background-color: white; -fx-padding: 10; -fx-background-radius: 10;");
        
        Label timeTitle = new Label("📊 TOTAL TIME PER ACTIVITY");
        timeTitle.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        timeTitle.setStyle("-fx-text-fill: #2c3e50;");
        
        VBox timeBox = new VBox(8);
        timeBox.setStyle("-fx-background-color: white; -fx-padding: 15; -fx-background-radius: 10;");
        Map<String, Integer> totalTime = Analytics.getTotalTimePerActivity(activityList);
        for (Map.Entry<String, Integer> entry : totalTime.entrySet()) {
            Label timeLabel = new Label(String.format("• %s: %d minutes (%.1f hours)", 
                entry.getKey(), entry.getValue(), entry.getValue() / 60.0));
            timeLabel.setFont(Font.font("Arial", 14));
            timeBox.getChildren().add(timeLabel);
        }
        
        Label dailyTitle = new Label("📅 DAILY SUMMARY");
        dailyTitle.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        dailyTitle.setStyle("-fx-text-fill: #2c3e50;");
        
        VBox dailyBox = new VBox(8);
        dailyBox.setStyle("-fx-background-color: white; -fx-padding: 15; -fx-background-radius: 10;");
        Map<String, Integer> dailySummary = Analytics.getDailySummary(activityList);
        dailySummary.entrySet().stream().limit(10).forEach(entry -> {
            Label dailyLabel = new Label(String.format("• %s: %d minutes", entry.getKey(), entry.getValue()));
            dailyLabel.setFont(Font.font("Arial", 14));
            dailyBox.getChildren().add(dailyLabel);
        });
        
        ScrollPane scrollPane = new ScrollPane();
        VBox contentBox = new VBox(15, title, frequentLabel, timeTitle, timeBox, dailyTitle, dailyBox);
        contentBox.setPadding(new Insets(10));
        scrollPane.setContent(contentBox);
        scrollPane.setFitToWidth(true);
        
        analyticsLayout.getChildren().add(scrollPane);
        Scene analyticsScene = new Scene(analyticsLayout);
        analyticsStage.setScene(analyticsScene);
        analyticsStage.show();
    }
    
    private void clearAll() {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Clear");
        confirm.setHeaderText("Clear all data?");
        confirm.setContentText("This will remove all activities from the table (file will remain unchanged).");
        
        if (confirm.showAndWait().get() == ButtonType.OK) {
            activityList.clear();
            statusLabel.setText("🗑️ All activities cleared from table");
            statusLabel.setStyle("-fx-text-fill: #e74c3c;");
        }
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
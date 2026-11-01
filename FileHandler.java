package activitytracker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "activities.csv";
    
    public static void appendActivity(Activity activity) throws IOException {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(activity.toCSV());
        }
    }
    
    public static List<Activity> loadActivities() throws IOException {
        List<Activity> activities = new ArrayList<>();
        File file = new File(FILE_NAME);
        
        if (!file.exists()) {
            return activities;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        Activity activity = Activity.fromCSV(line);
                        if (activity != null) {
                            activities.add(activity);
                        }
                    } catch (Exception e) {
                        System.err.println("Skipping corrupt line: " + line);
                    }
                }
            }
        }
        return activities;
    }
}
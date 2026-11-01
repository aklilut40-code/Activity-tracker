package activitytracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Activity {
    private String name;
    private int duration;
    private LocalDate date;
    
    public Activity(String name, int duration, LocalDate date) {
        this.name = name;
        this.duration = duration;
        this.date = date;
    }
    
    public String getName() { return name; }
    public int getDuration() { return duration; }
    public LocalDate getDate() { return date; }
    
    public void setName(String name) { this.name = name; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setDate(LocalDate date) { this.date = date; }
    
    public String toCSV() {
        return String.format("%s,%d,%s", name, duration, date.toString());
    }
    
    public static Activity fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            String name = parts[0];
            int duration = Integer.parseInt(parts[1]);
            LocalDate date = LocalDate.parse(parts[2]);
            return new Activity(name, duration, date);
        }
        return null;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("%-15s %-10d %s", name, duration, date.format(formatter));
    }
}
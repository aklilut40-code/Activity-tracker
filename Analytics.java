package activitytracker;

import java.util.*;

public class Analytics {
    
    public static Map<String, Integer> getTotalTimePerActivity(List<Activity> activities) {
        Map<String, Integer> totalTime = new LinkedHashMap<>();
        for (Activity activity : activities) {
            totalTime.put(activity.getName(), 
                totalTime.getOrDefault(activity.getName(), 0) + activity.getDuration());
        }
        return totalTime;
    }
    
    public static String getMostFrequentActivity(List<Activity> activities) {
        if (activities.isEmpty()) return "No data";
        
        Map<String, Integer> frequency = new HashMap<>();
        for (Activity activity : activities) {
            frequency.put(activity.getName(), 
                frequency.getOrDefault(activity.getName(), 0) + 1);
        }
        
        String mostFrequent = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        
        return mostFrequent + " (" + maxCount + " times)";
    }
    
    public static Map<String, Integer> getDailySummary(List<Activity> activities) {
        List<Activity> sortedActivities = new ArrayList<>(activities);
        sortedActivities.sort(Comparator.comparing(Activity::getDate).reversed());
        
        Map<String, Integer> dailySummary = new LinkedHashMap<>();
        for (Activity activity : sortedActivities) {
            String dateKey = activity.getDate().toString();
            dailySummary.put(dateKey, 
                dailySummary.getOrDefault(dateKey, 0) + activity.getDuration());
        }
        return dailySummary;
    }
    
    public static Map<String, Integer> getWeeklySummary(List<Activity> activities) {
        Map<String, Integer> weeklySummary = new LinkedHashMap<>();
        
        for (Activity activity : activities) {
            java.time.temporal.WeekFields weekFields = java.time.temporal.WeekFields.ISO;
            int weekNumber = activity.getDate().get(weekFields.weekOfWeekBasedYear());
            int year = activity.getDate().get(weekFields.weekBasedYear());
            String weekKey = year + " Week " + weekNumber;
            
            weeklySummary.put(weekKey, 
                weeklySummary.getOrDefault(weekKey, 0) + activity.getDuration());
        }
        
        Map<String, Integer> sortedSummary = new LinkedHashMap<>();
        weeklySummary.entrySet().stream()
            .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
            .forEachOrdered(e -> sortedSummary.put(e.getKey(), e.getValue()));
        
        return sortedSummary;
    }
    
    public static Map<String, Double> getAverageDurationPerActivity(List<Activity> activities) {
        Map<String, Double> averageDuration = new LinkedHashMap<>();
        Map<String, Integer> totalTime = getTotalTimePerActivity(activities);
        Map<String, Integer> frequency = new HashMap<>();
        
        for (Activity activity : activities) {
            frequency.put(activity.getName(), 
                frequency.getOrDefault(activity.getName(), 0) + 1);
        }
        
        for (String activityName : totalTime.keySet()) {
            double avg = (double) totalTime.get(activityName) / frequency.get(activityName);
            averageDuration.put(activityName, Math.round(avg * 10.0) / 10.0);
        }
        
        return averageDuration;
    }
}
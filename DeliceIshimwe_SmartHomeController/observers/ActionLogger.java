       
package observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * ActionLogger class: implements the Observer pattern to log device state changes.
 * Singleton class to ensure only one logger instance exists.
 */
public class ActionLogger implements Observer {
    // Singleton instance
    private static ActionLogger instance;
    
    // List to store log entries
    private List<String> logs;
    
    // Date formatter for timestamps
    private SimpleDateFormat dateFormat;
    
    /**
     * ActionLogger(): Private constructor to implement Singleton pattern
     */
    private ActionLogger() {
        logs = new ArrayList<>();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * Get the singleton instance of ActionLogger
     * @return The ActionLogger instance
     */
    public static synchronized ActionLogger getInstance() {
        if (instance == null) {
            instance = new ActionLogger();
        }
        return instance;
    }
    
    /**
     * logAction method: Log an action with timestamp
     * @param message The message to log
     */
    public void logAction(String message) {
        String timestamp = dateFormat.format(new Date());
        logs.add(timestamp + " - " + message);
        System.out.println("LOG: " + timestamp + " - " + message);
    }
    
    /**
     * getLogs method: Get all logs
     * @return A copy of the logs list
     */
    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }
    
    /**
     * update method: Receives updates from devices - bserver pattern implementation
     */
    @Override
    public void update(String deviceId, String deviceType, String location, String state) {
        logAction(deviceType + " [" + deviceId + "] in " + location + " changed to " + state);
    }
}









package observers;

/**
 * Subject interface: for the Observer pattern.
 * Classes implementing this interface can be observed by Observer objects.
 */
public interface Subject {
    /**
     * registerObserver method: Register an observer to receive notifications
     * @param observer The observer to register
     */
    void registerObserver(Observer observer);
    
    /**
     * removeObserver method: Remove an observer from the notification list
     * @param observer The observer to remove
     */
    void removeObserver(Observer observer);
    
    /**
     * notifyObservers method: Notify all registered observers about a state change
     */
    void notifyObservers();
}
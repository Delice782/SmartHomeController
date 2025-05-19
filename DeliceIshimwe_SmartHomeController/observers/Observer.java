package observers;

/**
 * Observer interface: for the Observer pattern.
 * Classes implementing this interface can receive notifications about device state changes.
 */
public interface Observer {
    
    /**
     * update method: Called when a subject's state changes
     * @param deviceId The ID of the device that changed state
     * @param deviceType The type of the device
     * @param location The location of the device
     * @param state The new state description (ON/OFF)
     */
    void update(String deviceId, String deviceType, String location, String state);
}
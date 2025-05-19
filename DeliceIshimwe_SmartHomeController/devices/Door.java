package devices;

/**
 * Door class: Concrete device implementation for a smart door
 */
public class Door extends AbstractDevice {
    private boolean isLocked;
    
    /**
     * Constructor for Door
     * @param deviceId Unique identifier for the door
     * @param location The location of the door
     */
    public Door(String deviceId, String location) {
        super(deviceId, location);
        this.isLocked = false;
    }
    
    /**
     * lock method: Lock the door
     */
    public void lock() {
        this.isLocked = true;
    }
    
    /**
     * unlock method: Unlock the door
     */
    public void unlock() {
        this.isLocked = false;
    }
    
    /**
     * isLocked method: Check if the door is locked
     * @return true if the door is locked, false otherwise
     */
    public boolean isLocked() {
        return isLocked;
    }
    
    /**
     * getDeviceType method: Get the device type
     * @return The device type ("Light", "Door", "AirCondictioner")
     */
    @Override
    public String getDeviceType() {
        return "Door";
    }
    
    @Override
    public String toString() {
        return super.toString() + " and is " + (isLocked ? "LOCKED" : "UNLOCKED");
    }
}
package devices;

/**
 * Device interface: All smart home devices implement this interface
 */
public interface Device {
    /**
     * turnOn method: Turn the device on
     */
    void turnOn();
    
    /**
     * turnOff method: Turn the device off
     */
    void turnOff();
    
    /**
     * isOn method: Check if the device is on
     * @return true if the device is on, false otherwise
     */
    boolean isOn();
    
    /**
     * getDeviceId method: Get the device ID
     * @return The device ID
     */
    String getDeviceId();
    
    /**
     * getDeviceType method: Get the device type
     * @return The device type ("Light", "Door", "AirCondictioner")
     */
    String getDeviceType();
    
    /**
     * getLocation method: Get the location of the device
     * @return The location (room) of the device
     */
    String getLocation();
    
    /**
     * String representation of the device state
     */
    String toString();
}
package devices;

/**
 * Light class: Concrete device implementation for lights
 */
public class Light extends AbstractDevice {
    
    /**
     * Constructor for Light
     * @param deviceId Unique identifier for the light
     * @param location The room where the light is located
     */
    public Light(String deviceId, String location) {
        super(deviceId, location);
    }
    
    /**
     * getDeviceType method: Get the device type
     * @return The device type ("Light", "Door", "AirCondictioner")
     */
    @Override
    public String getDeviceType() {
        return "Light";
    }
}
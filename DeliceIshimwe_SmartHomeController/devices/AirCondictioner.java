package devices;

/**
 * AirCondictioner class: Concrete device implementation for air conditioners
 */
public class AirCondictioner extends AbstractDevice {
    private int temperature;
    
    /**
     * Constructor for AirCondictioner
     * @param deviceId Unique identifier for the AirCondictioner
     * @param location The room where the AirCondictioner is located
     */
    public AirCondictioner(String deviceId, String location) {
        super(deviceId, location);
        this.temperature = 24; // Default temperature
    }
    
    /**
     * setTemperature method: Set the temperature of the AirCondictioner
     * @param temperature The temperature in degrees Celsius
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    
    /**
     * getTemperature method: Get the current temperature setting
     * @return The temperature in degrees Celsius
     */
    public int getTemperature() {
        return temperature;
    }
    
    /**
     * getDeviceType method: Get the device type
     * @return The device type ("Light", "Door", "AirCondictioner")
     */
    @Override
    public String getDeviceType() {
        return "AirCondictioner";
    }
    
    @Override
    public String toString() {
        return super.toString() + " at " + temperature + "°C";
    }
}
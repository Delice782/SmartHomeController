package devices;

/**
 * DeviceFactory class: Implements the Factory Pattern to create different types of devices
 */
public class DeviceFactory {
    
    /**
     * createDevice method: Create a device based on the specified type
     * @param deviceType The type of device to create ("light", "door", "AirCondictioner")
     * @param deviceId The unique identifier for the device
     * @param location The location where the device is installed
     * @return A new Device instance of the specified type
     */
    public static Device createDevice(String deviceType, String deviceId, String location) {
        switch(deviceType.toLowerCase()) {
            case "light":
                return new Light(deviceId, location);
            case "door":
                return new Door(deviceId, location);
            case "aircondictioner":
                return new AirCondictioner(deviceId, location);
            default:
                throw new IllegalArgumentException("Unknown device type: " + deviceType);
        }
    }
}
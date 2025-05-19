 
package decorators;

import devices.Device;

/**
 * DeviceDecorator class: This is a base class for the Decorator Pattern
 * Allows adding additional functionality to devices at runtime
 */
public abstract class DeviceDecorator implements Device {
    protected Device decoratedDevice;
    
    /**
     * Constructor for DeviceDecorator
     * @param device The device to decorate
     */
    public DeviceDecorator(Device device) {
        this.decoratedDevice = device;
    }
    
    /**
     * turnOn method: Turn the device on
     */
    @Override
    public void turnOn() {
        decoratedDevice.turnOn();
    }
    
    /**
     * turnOff method: Turn the device off
     */
    @Override
    public void turnOff() {
        decoratedDevice.turnOff();
    }
    
    /**
     * isOn method: Check if the device is on
     * @return true if the device is on, false otherwise
     */
    @Override
    public boolean isOn() {
        return decoratedDevice.isOn();
    }
    
    /**
     * getDeviceId method: Get the device ID
     * @return The device ID
     */
    @Override
    public String getDeviceId() {
        return decoratedDevice.getDeviceId();
    }
    
    /**
     * getDeviceType method: Get the device type
     * @return The device type ("Light", "Door", "AirCondictioner")
     */
    @Override
    public String getDeviceType() {
        return decoratedDevice.getDeviceType();
    }
    
    /**
     * getLocation method: Get the location of the device
     * @return The location (room) of the device
     */
    @Override
    public String getLocation() {
        return decoratedDevice.getLocation();
    }
}

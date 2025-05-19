   
package rooms;

import java.util.ArrayList;
import java.util.List;
import devices.Device;

/**
 * Room class: Represents a room in the smart home that contains devices
 */
public class Room {
    private String name;
    private List<Device> devices;
    
    /**
     * Constructor for Room
     * @param name The name of the room
     */
    public Room(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }
    
    /**
     * getName method: Get the room name
     * @return The name of the room
     */
    public String getName() {
        return name;
    }
    
    /**
     * addDevice method: Add a device to this room
     * @param device The device to add
     */
    public void addDevice(Device device) {
        devices.add(device);
    }
    
    /**
     * removeDevice method: Remove a device from this room
     * @param device The device to remove
     */
    public void removeDevice(Device device) {
        devices.remove(device);
    }
    
    /**
     * getDevices method: Get all devices in this room
     * @return List of devices in the room
     */
    public List<Device> getDevices() {
        return new ArrayList<>(devices);
    }
    
    /**
     * turnOnAllDevices method: Turn on all devices in the room
     */
    public void turnOnAllDevices() {
        for (Device device : devices) {
            device.turnOn();
        }
    }
    
    /**
     * turnOffAllDevices method: Turn off all devices in the room
     */
    public void turnOffAllDevices() {
        for (Device device : devices) {
            device.turnOff();
        }
    }
    
    /**
     * toString method: String representation of the room and its devices
     */
    @Override
    public String toString() {
        return "Room: " + name + " with " + devices.size() + " devices";
    }
}

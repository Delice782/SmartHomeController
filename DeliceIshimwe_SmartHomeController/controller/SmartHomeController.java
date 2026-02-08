                                                        
package controller;
 
import devices.Device;
import observers.ActionLogger;
import observers.Subject;
import rooms.Room;
import strategy.AutomationMode;

import java.util.ArrayList;
import java.util.List;

/**
 * SmartHomeController class: Central controller for the smart home system.
 * Implements Singleton pattern to ensure only one controller exists.
 */
public class SmartHomeController {
    
    private static SmartHomeController instance;
    
    // List of rooms in the smart home
    private List<Room> rooms;
    
    // Action logger
    private ActionLogger logger;
    
    /**
     * SmartHomeController(): Private constructor to implement Singleton pattern
     */
    private SmartHomeController() {
        rooms = new ArrayList<>();
        logger = ActionLogger.getInstance();
    }
    
    /**
     * Get the singleton instance of SmartHomeController
     * @return The SmartHomeController instance
     */
    public static synchronized SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }
    
    /**
     * addRoom method: Add a room to the smart home
     * @param room The room to add
     */
    public void addRoom(Room room) {
        rooms.add(room);
        logger.logAction("New Room added: " + room.getName());
        
        // Register the logger as an observer for all devices in the room
        for (Device device : room.getDevices()) {
            if (device instanceof Subject) {
                ((Subject) device).registerObserver(logger);
            }
        }
    }
    
    /**
     * addDeviceToRoom method: Add a device to an existing room and register it with observers
     * @param roomName The name of the room
     * @param device The device to add
     */
    public void addDeviceToRoom(String roomName, Device device) {
        Room room = getRoom(roomName);
        if (room != null) {
            room.addDevice(device);
            
            // Register the device with the observer
            if (device instanceof Subject) {
                ((Subject) device).registerObserver(logger);
            }
            
            logger.logAction("New " + device.getDeviceType() + " added to " + roomName);
        }
    }
    
    /**
     * getRoom method: Get a room by name
     * @param roomName The name of the room to find
     * @return The room, or null if not found
     */
    public Room getRoom(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                return room;
            }
        }
        return null;
    }
    
    /**
     * getAllRooms method: Get all rooms in the smart home
     * @return A copy of the rooms list
     */
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }
    
    /**
     * controlDevice method: Control an individual device
     * @param device The device to control
     * @param turnOn True to turn on, false to turn off
     */
    public void controlDevice(Device device, boolean turnOn) {
        if (turnOn) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }
    
    /**
     * controlAllDeviceInRoom method: Control all devices in a room
     * @param room The room containing the devices
     * @param turnOn True to turn on all devices, false to turn off all devices
     */
    public void controlAllDevicesInRoom(Room room, boolean turnOn) {
        if (turnOn) {
            room.turnOnAllDevices();
            logger.logAction("All devices in " + room.getName() + " turned ON");
        } else {
            room.turnOffAllDevices();
            logger.logAction("All devices in " + room.getName() + " turned OFF");
        }
    }
    
    /**
     * executeAutomationMode method: Execute an automation mode
     * @param mode The automation mode to execute
     */
    public void executeAutomationMode(AutomationMode mode) {
        mode.execute(rooms);
        logger.logAction("Executed automation mode: " + mode.getModeName());
    }
    
    /**
     * printLog method: Print all logs
     */
    public void printLog() {
        List<String> logs = logger.getLogs();
        for (String log : logs) {
            System.out.println(log);
        }
    }
}


















































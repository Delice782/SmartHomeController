import controller.SmartHomeController;
import devices.*;
import decorators.MotionSensorDecorator;
import rooms.Room;
import strategy.*;
import observers.ActionLogger;
import observers.Subject;
 
public class Main {
    public static void main(String[] args) {
        // Get the singleton controller instance
        SmartHomeController controller = SmartHomeController.getInstance();
        
        // Get the logger instance
        ActionLogger logger = ActionLogger.getInstance();
        
        // Create rooms
        Room livingRoom = new Room("Living Room");
        Room bedroom = new Room("Bedroom");
        Room kitchen = new Room("Kitchen");
    
        // Create devices using the factory
        Device livingRoomLight = DeviceFactory.createDevice("light", "L1", "Living Room");
        Device bedroomLight = DeviceFactory.createDevice("light", "L2", "Bedroom");
        Device kitchenLight = DeviceFactory.createDevice("light", "L3", "Kitchen");

        Device frontDoor = DeviceFactory.createDevice("door", "D1", "Living Room");
        Device bedroomDoor = DeviceFactory.createDevice("door", "D2", "Bedroom");
        
        Device livingRoomAC = DeviceFactory.createDevice("aircondictioner", "AC1", "Living Room");
        Device bedroomAC = DeviceFactory.createDevice("aircondictioner", "AC2", "Bedroom");
        
        // Register devices with the ActionLogger observer 
        if (livingRoomLight instanceof Subject) {
            ((Subject) livingRoomLight).registerObserver(logger);
        }
        
        if (bedroomLight instanceof Subject) {
            ((Subject) bedroomLight).registerObserver(logger);
        }
        
        if (kitchenLight instanceof Subject) {
            ((Subject) kitchenLight).registerObserver(logger);
        }
        
        if (frontDoor instanceof Subject) {
            ((Subject) frontDoor).registerObserver(logger);
        }
        
        if (bedroomDoor instanceof Subject) {
            ((Subject) bedroomDoor).registerObserver(logger);
        }
        
        if (livingRoomAC instanceof Subject) {
            ((Subject) livingRoomAC).registerObserver(logger);
        }
        
        if (bedroomAC instanceof Subject) {
            ((Subject) bedroomAC).registerObserver(logger);
        }
        
        System.out.println("\n__________SMART HOME CONTROLLER - A Design Pattern Showcase__________\n");
        // Add devices to rooms
        livingRoom.addDevice(livingRoomLight);
        livingRoom.addDevice(frontDoor);
        livingRoom.addDevice(livingRoomAC);
        
        bedroom.addDevice(bedroomLight);
        bedroom.addDevice(bedroomDoor);
        bedroom.addDevice(bedroomAC);
        
        kitchen.addDevice(kitchenLight);
        
        // Add rooms to controller
        controller.addRoom(livingRoom);
        controller.addRoom(bedroom);
        controller.addRoom(kitchen);
        
        // Applying decorator pattern - add motion sensor to a light
        Device enhancedLight = new MotionSensorDecorator(livingRoomLight);
        System.out.println("\n Device created: " + enhancedLight);
        
        // test individual device control feature
        System.out.println("\nIndividual Device Control:");
        controller.controlDevice(livingRoomLight, true);  
        controller.controlDevice(bedroomAC, true);      
        
        // test room-based control feature
        System.out.println("\nRoom-based Control:");
        controller.controlAllDevicesInRoom(kitchen, true); 
        
        // test automation modes (Strategy Pattern)
        System.out.println("\nAutomation Modes:");
        
        // automation mode - Night Mode
        AutomationMode nightMode = new NightMode();
        controller.executeAutomationMode(nightMode);
        
        // Show the status of all devices after Night Mode
        System.out.println("\nHome Devices Status After Activating Night Mode:");
        for (Room room : controller.getAllRooms()) {
            System.out.println("Room: " + room.getName());
            for (Device device : room.getDevices()) {
                System.out.println("  " + device);
            }
        }
        
        // Turning some devices back on for demonstration
        controller.controlDevice(livingRoomLight, true);
        controller.controlDevice(kitchenLight, true);
        
        // automation mode - Vacation Mode
        System.out.println("\nSwitching to Vacation Mode:");
        AutomationMode vacationMode = new VacationMode();
        controller.executeAutomationMode(vacationMode);
        
        // Show the status of all devices after Vacation Mode
        System.out.println("\nHome Devices Status After Activating Vacation Mode:");
        for (Room room : controller.getAllRooms()) {
            System.out.println("Room: " + room.getName());
            for (Device device : room.getDevices()) {
                System.out.println("  " + device);
            }
        }
        
        // Print the action log
        System.out.println("\nAction Log:");
        controller.printLog();
    }
}
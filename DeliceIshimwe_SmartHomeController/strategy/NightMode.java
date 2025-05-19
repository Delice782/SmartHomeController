package strategy;

import java.util.List;
import devices.*;
import rooms.Room;

/**
 * NightMode class: Concrete strategy for night mode automation
 * Turns off all lights, locks doors, and sets AirCondictioners to 20°C
 */
public class NightMode implements AutomationMode {
    
    @Override
    public String getModeName() {
        return "Night Mode";
    }
    
    @Override
    public void execute(List<Room> rooms) {
        for (Room room : rooms) {
            for (Device device : room.getDevices()) {
                // Turn off all lights
                if (device instanceof Light) {
                    device.turnOff();
                }
                
                // Lock all doors
                else if (device instanceof Door) {
                    ((Door) device).lock();
                }
                
                // Set ACs to 20°C
                else if (device instanceof AirCondictioner) {
                    if (!device.isOn()) {
                        device.turnOn();
                    }
                    ((AirCondictioner) device).setTemperature(20);
                }
            }
        }
    }
}
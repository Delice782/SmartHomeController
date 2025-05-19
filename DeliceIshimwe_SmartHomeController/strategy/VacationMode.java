package strategy;

import java.util.List;
import devices.*;
import rooms.Room;

/**
 * VacationMode class: Concrete strategy for vacation mode automation
 * Turns off all lights and AirCondictioners, and locks all doors
 */
public class VacationMode implements AutomationMode {
    
    @Override
    public String getModeName() {
        return "Vacation Mode";
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
                
                // Turn off all AirCondictioners
                else if (device instanceof AirCondictioner) {
                    device.turnOff();
                }
            }
        }
    }
}
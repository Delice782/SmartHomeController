package strategy;

import java.util.List;
import rooms.Room;

/**
 * AutomationMode interface: Strategy interface for different automation modes
 * 
 */
public interface AutomationMode {
    /**
     * getModeName method: Get the name of this automation mode
     * @return The mode name
     */
    String getModeName();
    
    /**
     * execute method: Execute this automation mode on the provided rooms
     * @param rooms The list of rooms to apply the automation
     */
    void execute(List<Room> rooms);
}
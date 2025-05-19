package devices;

import observers.Observer;
import observers.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractDevice class: Abstract base class for all smart home devices
 */
public abstract class AbstractDevice implements Device, Subject {
   private String deviceId;
   private String location;
   private boolean isOn;
   private List<Observer> observers;
   
    /**
     * Constructor for AbstractDevice
     * @param deviceId Unique identifier for the device
     * @param location Room location of the device
     */
    public AbstractDevice(String deviceId, String location) {
       this.deviceId = deviceId;
       this.location = location;
       this.isOn = false;
       this.observers = new ArrayList<>();
    }
   
    /**
     * isOn method: Check if the device is on
     * @return true if the device is on, false otherwise
     */
    @Override
    public boolean isOn() {
       return isOn;
    }
   
    /**
     * turnOn method: Turn the device on
     */
    @Override
    public void turnOn() {
       boolean oldState = this.isOn;
       this.isOn = true;
       if (oldState != isOn) {
           notifyObservers();
       }
    }
   
    /**
     * turnOff method: Turn the device off
     */
    @Override
    public void turnOff() {
       boolean oldState = this.isOn;
       this.isOn = false;
       if (oldState != isOn) {
           notifyObservers();
       }
    }
   
    /**
     * getDeviceId method: Get the  ID of the device
     * @return The ID of the device
     */
    @Override
    public String getDeviceId() {
       return deviceId;
    }
   
    /**
     * getLocation method: Get the location of the device
     * @return The location (room) of the device
     */
    @Override
    public String getLocation() {
       return location;
    }
   
    @Override
    public String toString() {
       return getDeviceType() + " [" + deviceId + "] in " + location + " is " + (isOn ? "ON" : "OFF");
    }
   
    /*
     * registerObserver method: Register an observer to receive notifications, Subject interface implementation
     * @param observer The observer to register
     */
    @Override
    public void registerObserver(Observer observer) {
       if (!observers.contains(observer)) {
           observers.add(observer);
       }
    }
   
    /**
     * removeObserver method: Remove an observer from the notification list
     * @param observer The observer to remove
     */
    @Override
    public void removeObserver(Observer observer) {
       observers.remove(observer);
    }
   
    /**
     * notifyObservers method: Notify all registered observers about a state change
     */
    @Override
    public void notifyObservers() {
       for (Observer observer : observers) {
           observer.update(
               deviceId, 
               getDeviceType(), 
               location, 
               isOn ? "ON" : "OFF"
           );
       }
    }
}
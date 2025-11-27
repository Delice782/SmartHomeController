   
package decorators;

import devices.Device;

/**
 * MotionSensorDecorator class: Adds motion detection capabilities to a device
 */
public class MotionSensorDecorator extends DeviceDecorator {
    private boolean motionDetectionEnabled;
    
    /**
     * Constructor for MotionSensorDecorator
     * @param device The device to enhance with motion detection
     */
    public MotionSensorDecorator(Device device) {
        super(device);
        this.motionDetectionEnabled = false;
    }
    
    /**
     * enableMotionDetection method: Enable motion detection
     */
    public void enableMotionDetection() {
        this.motionDetectionEnabled = true;
        System.out.println("Motion detection enabled for " + decoratedDevice.getDeviceType() + 
                         " [" + decoratedDevice.getDeviceId() + "]");
    }
    
    /**
     * disableMotionDetection method: Disable motion detection
     */
    public void disableMotionDetection() {
        this.motionDetectionEnabled = false;
        System.out.println("Motion detection disabled for " + decoratedDevice.getDeviceType() + 
                         " [" + decoratedDevice.getDeviceId() + "]");
    }
    
    /**
     * isMotionDetectionEnabled method: Check if motion detection is enabled
     * @return true if motion detection is enabled, false otherwise
     */
    public boolean isMotionDetectionEnabled() {
        return motionDetectionEnabled;
    }
    
    @Override
    public String toString() {
        return decoratedDevice.toString() + (motionDetectionEnabled ? " with MOTION DETECTION" : "");
    }

}




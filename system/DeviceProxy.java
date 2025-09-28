//Structural pattern


package system;

public class DeviceProxy {
    private final Device device;

    public DeviceProxy(Device device) {
        this.device = device;
    }

    public void turnOn() {
        // Add access control or logging if needed
        device.turnOn();
        System.out.println("Device " + device.getId() + " turned ON via proxy.");
    }

    public void turnOff() {
        device.turnOff();
        System.out.println("Device " + device.getId() + " turned OFF via proxy.");
    }

    public Device getDevice() { return device; }
}

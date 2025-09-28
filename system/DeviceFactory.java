//Creational pattern

package system;

public class DeviceFactory {
    public static Device createDevice(int id, DeviceType type) {
        return new Device(id, type);
    }
}

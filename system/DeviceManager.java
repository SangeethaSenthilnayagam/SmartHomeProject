package system;

import java.util.ArrayList;
import java.util.List;

public class DeviceManager {
    private final List<Device> devices = new ArrayList<>();
    private final List<DeviceObserver> observers = new ArrayList<>();

    public void addDevice(Device d) {
        devices.add(d);
        notifyObservers("Device added: " + d.getId());
    }

    public void removeDevice(int id) throws AppException {
        Device d = devices.stream().filter(dev -> dev.getId() == id).findFirst().orElse(null);
        if(d == null) throw new AppException("Device not found.");
        devices.remove(d);
        notifyObservers("Device removed: " + id);
    }

    public void registerObserver(DeviceObserver o) { observers.add(o); }

    private void notifyObservers(String message) {
        for(DeviceObserver o : observers) o.update(message);
    }

    public void printStatus() {
        if(devices.isEmpty()) System.out.println("No devices added.");
        devices.forEach(d -> System.out.println(d.statusReport()));
    }

    public Device findDevice(int id) {
        return devices.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }
}

package system;

public class Device {
    private final int id;
    private final DeviceType type;
    private boolean status; // on/off for light & door
    private int temperature; // only for thermostat

    public Device(int id, DeviceType type) {
        this.id = id;
        this.type = type;
        this.status = false;
        if (type == DeviceType.THERMOSTAT) this.temperature = 70; // default
    }

    public int getId() { return id; }
    public DeviceType getType() { return type; }
    public boolean isOn() { return status; }
    public void turnOn() { status = true; }
    public void turnOff() { status = false; }

    public int getTemperature() { return temperature; }
    public void setTemperature(int temp) { 
        if(type == DeviceType.THERMOSTAT) temperature = temp; 
    }

    public String statusReport() {
        switch(type) {
            case LIGHT: return "Light " + id + " is " + (status ? "On" : "Off");
            case DOOR: return "Door " + id + " is " + (status ? "Unlocked" : "Locked");
            case THERMOSTAT: return "Thermostat " + id + " is set to " + temperature + "°F";
            default: return "Unknown device";
        }
    }
}

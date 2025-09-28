SmartHomeProject/
           └── system/
                 ├── Main.java
                 ├── App.java
                 ├── Device.java
                 ├── DeviceFactory.java
                 ├── DeviceProxy.java
                 ├── DeviceManager.java
                 ├── DeviceType.java
                 ├── AppException.java
                 └── DeviceObserver.java



# Smart Home System (Java Console Project)

A console-based Smart Home simulation using **OOP + Design Patterns**:
- Factory Pattern (for device creation)
- Observer Pattern (for notifications)
- Proxy Pattern (for access control)
# output:

>>java com/smarthome/system/Main

Commands: 1.Add 2.Remove 3.Status 4.Control 0.Exit
Choice: 1
Device ID: 123
Device Type (LIGHT, THERMOSTAT, DOOR):
Error: No enum constant com.smarthome.system.DeviceType.

Commands: 1.Add 2.Remove 3.Status 4.Control 0.Exit
Choice: 1
Device ID: 123
Device Type (LIGHT, THERMOSTAT, DOOR): light
Observer: Device added: 123

Commands: 1.Add 2.Remove 3.Status 4.Control 0.Exit
Choice: 1
Device ID: 122
Device Type (LIGHT, THERMOSTAT, DOOR): thermostat
Observer: Device added: 122

Commands: 1.Add 2.Remove 3.Status 4.Control 0.Exit
Choice: 3
Light 123 is Off
Thermostat 122 is set to 70°F

Commands: 1.Add 2.Remove 3.Status 4.Control 0.Exit
Choice: 4
Enter Device ID to control: 123
Turn (ON/OFF): on
Device 123 turned ON via proxy.

Commands: 1.Add 2.Remove 3.Status 4.Control 0.Exit
Choice: 3
Light 123 is On
Thermostat 122 is set to 70°F

Commands: 1.Add 2.Remove 3.Status 4.Control 0.Exit
Choice: 0
Exiting Smart Home System.



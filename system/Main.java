package system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DeviceManager manager = new DeviceManager();
        manager.registerObserver(msg -> System.out.println("Observer: " + msg));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("\nCommands: 1.Add 2.Remove 3.Status 4.Control 0.Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();

            try {
                switch(choice) {
                    case "1":
                        System.out.print("Device ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Device Type (LIGHT, THERMOSTAT, DOOR): ");
                        DeviceType type = DeviceType.valueOf(sc.nextLine().toUpperCase());
                        Device d = DeviceFactory.createDevice(id, type);
                        manager.addDevice(d);
                        break;
                    case "2":
                        System.out.print("Device ID to remove: ");
                        int rid = Integer.parseInt(sc.nextLine());
                        manager.removeDevice(rid);
                        break;
                    case "3":
                        manager.printStatus();
                        break;
                    case "4":
                           System.out.print("Enter Device ID to control: ");
                           int cid = Integer.parseInt(sc.nextLine());
                           Device target = manager.findDevice(cid);
                          if(target == null) {
                            System.out.println("Device not found.");
                           } else {
                          DeviceProxy proxy = new DeviceProxy(target);
                          if(target.getType() == DeviceType.THERMOSTAT) {
                             System.out.print("Set new temperature: ");
                             int t = Integer.parseInt(sc.nextLine());
                             target.setTemperature(t);
                             System.out.println("Temperature updated.");
                          } else {
                             System.out.print("Turn (ON/OFF): ");
                             String act = sc.nextLine().toUpperCase();
                             if(act.equals("ON")) proxy.turnOn();
                             else if(act.equals("OFF")) proxy.turnOff();
                             else System.out.println("Invalid action.");
                    }
                }
                break;
                    case "0":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Exiting Smart Home System.");
    }
}

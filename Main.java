import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("simulation.txt");
        Scanner scanner = new Scanner(fis);
        LinkedEventList eventList = new LinkedEventList();
        Map<Integer, SimpleHost> hosts = new HashMap<>();

        // Read the initial setup from the file
        int centralHostAddress = scanner.nextInt();
        SimpleHost centralHost = new SimpleHost(centralHostAddress, eventList);
        hosts.put(centralHostAddress, centralHost);

        // Read neighbor configuration
        while (scanner.hasNextInt()) {
            int neighborAddress = scanner.nextInt();

            if (neighborAddress == -1) break; // -1 means break

            int distance = scanner.nextInt();

            SimpleHost neighbor = new SimpleHost(neighborAddress, eventList);
            hosts.put(neighborAddress, neighbor);

            centralHost.addNeighbor(neighbor, distance);
            neighbor.addNeighbor(centralHost, distance);  // bidirectional connection
        }

        // Read ping configuration
        while (scanner.hasNextInt()) {
            int srcAddress = scanner.nextInt();

            int destAddress = scanner.nextInt();

            int interval = scanner.nextInt();

            int duration = scanner.nextInt();

            SimpleHost srcHost = hosts.get(srcAddress);
            srcHost.sendPings(destAddress, interval, duration);

        }

        scanner.close();
        fis.close();

        // Start simulation
        while (eventList.size() > 0) {
            Event nextEvent = eventList.removeFirst();
            nextEvent.handle();
        }
    }
}
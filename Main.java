import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        // open file and read it
        FileInputStream fileByteStream = new FileInputStream("simulation.txt");
        Scanner fileScanner = new Scanner(fileByteStream);

        while (fileScanner.hasNext()) {
            int host = fileScanner.nextInt();
            SimpleHost simpleHost = new SimpleHost();
        }
    }
}

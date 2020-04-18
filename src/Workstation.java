import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Workstation{
    protected Buffer<Component1> c1Buffer;
    protected ArrayList<Float> procTimes;

    public Workstation(String dataPath) throws FileNotFoundException {
        c1Buffer = new Buffer<Component1>();
        procTimes = new ArrayList<>();

        File file = new File(dataPath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            try {
                procTimes.add(Float.parseFloat(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.printf("Failed to read string, but continuing: %s\n", e.toString());
            }
        }
    }

    public Buffer<Component1> getc1Buffer(){
        return c1Buffer;
    }
}
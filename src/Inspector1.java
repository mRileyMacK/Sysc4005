import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inspector1 extends Inspector {
    private Buffer<Component1> comp1Buf;
    private ArrayList<Float> inspTimes;

    public Inspector1(String dataPath, Buffer<Component1> comp1Buf) throws FileNotFoundException {
        super();
        this.comp1Buf = comp1Buf;
        inspTimes = new ArrayList<>();
        File file = new File(dataPath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            try {
                inspTimes.add(Float.parseFloat(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.printf("Failed to read string, but continuing: %s\n", e.toString());
            }
        }
    }

    public Component getNextComponent(){
        return compFactory.getComponent(COMPONENT_TYPE.C1);
    }

    @Override
    public void inspect(Component c) {

    }
}

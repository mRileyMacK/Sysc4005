import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Inspector2 extends Inspector{
    private Random rd;
    private ArrayList<Float> comp2InspTimes;
    private ArrayList<Float> comp3InspTimes;
    private Buffer<Component2> comp2Buf;
    private Buffer<Component3> comp3Buf;

    public Inspector2(
            String comp2DataPath,
            String comp3DataPath,
            Buffer<Component2> comp2Buf,
            Buffer<Component3> comp3Buf
    ) throws FileNotFoundException {
        super();
        rd = new Random();
        comp2InspTimes = new ArrayList<>();
        comp3InspTimes = new ArrayList<>();
        this.comp2Buf = comp2Buf;
        this.comp3Buf = comp3Buf;
        File file = new File(comp2DataPath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            try {
                comp2InspTimes.add(Float.parseFloat(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.printf("Failed to read string, but continuing: %s\n", e.toString());
            }
        }
        file = new File(comp3DataPath);
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            try {
                comp3InspTimes.add(Float.parseFloat(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.printf("Failed to read string, but continuing: %s\n", e.toString());
            }
        }
    }

    public boolean isNextComp2(){
        return rd.nextBoolean();
    }

    public Component getNextComponent(){
        if(isNextComp2()){
            return compFactory.getComponent(COMPONENT_TYPE.C2);
        }
        else {
            return compFactory.getComponent(COMPONENT_TYPE.C3);
        }
    }

    @Override
    public void inspect(Component c) {
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Inspector2 extends Inspector{
    private Random rd;
    private ArrayList<Float> comp2InspTimes;
    private ArrayList<Float> comp3InspTimes;
    private int comp2InspTimesIndex;
    private int comp3InspTimesIndex;
    private Buffer<Component2> comp2Buf;
    private Buffer<Component3> comp3Buf;

    public Inspector2(
            String comp2DataPath,
            String comp3DataPath,
            Buffer<Component2> comp2Buf,
            Buffer<Component3> comp3Buf,
            FactoryWorkstations fw,
            int iterations
    ) throws FileNotFoundException {
        super(fw, iterations);
        comp2InspTimesIndex = 0;
        comp3InspTimesIndex = 0;
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
    public Workstation passToBuffer(Component c) {
        if(c instanceof Component2){
            while(true){
                if(workstations.getW2().getC2Buffer().getComponentQueue().offer((((Component2)c)))){
                    return workstations.getW2();
                }
            }
        }
        else if (c instanceof Component3){
            while(true){
                if(workstations.getW3().getC3Buffer().getComponentQueue().offer((((Component3)c)))){
                    return workstations.getW2();
                }
            }
        }
        else{
            System.out.println("Inspector 2 has passed Component 1");
            return null;
        }

    }

    protected Float getNextCompTime(Component c) {
        Float toRet;
        if(c instanceof Component2){
            if(comp2InspTimesIndex < comp2InspTimes.size()){
                toRet = comp2InspTimes.get(comp2InspTimesIndex);
                comp2InspTimesIndex++;
                return toRet;
            }
            else{
                toRet = comp2InspTimes.get(0);
                comp2InspTimesIndex = 1;
                return toRet;
            }
        }
        else if(c instanceof Component3){
            if(comp3InspTimesIndex < comp3InspTimes.size()){
                toRet = comp3InspTimes.get(comp3InspTimesIndex);
                comp3InspTimesIndex++;
                return toRet;
            }
            else{
                toRet = comp3InspTimes.get(0);
                comp3InspTimesIndex = 1;
                return toRet;
            }
        }
        else{
            System.out.println("Wrong component type");
            return null;
        }

    }

    @Override
    public int getNum() {
        return 2;
    }
}

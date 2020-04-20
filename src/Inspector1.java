import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inspector1 extends Inspector {
    private Buffer<Component1> comp1Buf;
    private ArrayList<Float> inspTimes;
    private int inspTimeIndex;
    public Inspector1(String dataPath,
                      Buffer<Component1> comp1Buf,
                      FactoryWorkstations fw,
                      int iterations) throws FileNotFoundException {
        super(fw,iterations);
        inspTimeIndex = 0;
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
    public Workstation passToBuffer(Component c) {
        if(c instanceof Component1){
            if(workstations.getW1().getc1Buffer().getComponentQueue().isEmpty()
            || (workstations.getW1().getc1Buffer().getComponentQueue().size() == 1 &&
                    workstations.getW2().getc1Buffer().getComponentQueue().size() == 1 &&
                    workstations.getW3().getc1Buffer().getComponentQueue().size() ==1)
            ){
                workstations.getW1().getc1Buffer().getComponentQueue().offer((Component1)c);
                return workstations.getW1();
            }
            else if(workstations.getW2().getc1Buffer().getComponentQueue().isEmpty() ||
                    (workstations.getW2().getc1Buffer().getComponentQueue().size() == 1 &&
                            workstations.getW3().getc1Buffer().getComponentQueue().size() ==1)
            ){
                workstations.getW2().getc1Buffer().getComponentQueue().offer((Component1)c);
                return workstations.getW2();
            }
            else if(workstations.getW3().getc1Buffer().getComponentQueue().isEmpty() ||
                workstations.getW3().getc1Buffer().getComponentQueue().size() == 1){
                workstations.getW3().getc1Buffer().getComponentQueue().offer((Component1) c);
                return workstations.getW3();

            }
            
            while(true){
                if(workstations.getW1().getc1Buffer().getComponentQueue().offer((((Component1)c)))){
                    return workstations.getW1();
                }
                if(workstations.getW2().getc1Buffer().getComponentQueue().offer((Component1)c)){
                    return workstations.getW2();
                }
                if(workstations.getW3().getc1Buffer().getComponentQueue().offer((Component1)c)){
                    return workstations.getW3();
                }
            }
        }
       else{
           System.out.println("Inspector1 trying to pass C2 or C3");
           return null;
        }
    }

    @Override
    protected Float getNextCompTime(Component c) {
        Float toRet;
        if(c instanceof Component1){
            if(inspTimeIndex < inspTimes.size()){
                toRet = inspTimes.get(inspTimeIndex);
                inspTimeIndex++;
                return toRet;
            }
            else{
                toRet = inspTimes.get(0);
                inspTimeIndex = 1;
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
        return 1;
    }
}

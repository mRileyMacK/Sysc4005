import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Workstation implements Runnable{
    protected Buffer<Component1> c1Buffer;
    protected ArrayList<Float> procTimes;
    public static int ITERATIONS;
    protected int procTimeindex;

    public Workstation(String dataPath, int iterations) throws FileNotFoundException {
        c1Buffer = new Buffer<Component1>();
        procTimes = new ArrayList<>();
        ITERATIONS = iterations;
        procTimeindex = 0;
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

    @Override
    public void run(){
        for(int i = 0; i<ITERATIONS; i++){
            buildProduct();
        }
    }

    public Component1 getNextC1(){
        Component1 c1 = (Component1) getc1Buffer().getNextComponent();
        System.out.println("Worstation " + this.getNum() + " got component 1");
        return c1;
    }

    public Float getNextProcTime(){
        Float toRet;
        if(procTimeindex < procTimes.size()){
            toRet = procTimes.get(procTimeindex);
            procTimeindex++;
            return toRet;
        }
        else{
            toRet = procTimes.get(0);
            procTimeindex = 1;
            return toRet;
        }
    }

    public abstract int getNum();
    public abstract Product buildProduct();
}
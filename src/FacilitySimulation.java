import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class FacilitySimulation {
    public static int p1made;
    public static int p2made;
    public static int p3made;
    public static void main(String[] args) {
        WorkstationFactory wsFactory = new WorkstationFactory();
        try {
            p1made = 0; p2made = 0; p3made = 0;
            Workstation ws1 = wsFactory.getWorkstation(WORKSTATION_TYPE.W1, "historical-data/ws1.dat", 10000000);
            Workstation ws2 = wsFactory.getWorkstation(WORKSTATION_TYPE.W2, "historical-data/ws2.dat", 10000000);
            Workstation ws3 = wsFactory.getWorkstation(WORKSTATION_TYPE.W3, "historical-data/ws3.dat", 10000000);

            FactoryWorkstations fw = new FactoryWorkstations((Workstation1)ws1, (Workstation2)ws2, (Workstation3)ws3);

            Inspector1 insp1 = new Inspector1(
                    "historical-data/servinsp1.dat",
                    new Buffer<Component1>(),
                    fw,
                    500);
            Inspector2 insp2 = new Inspector2(
                    "historical-data/servinsp22.dat",
                    "historical-data/servinsp22.dat",
                    new Buffer<Component2>(),
                    new Buffer<Component3>(),
                    fw,
                    500);

            ExecutorService executor = Executors.newCachedThreadPool();
            executor.execute(insp1);
            executor.execute(insp2);
            executor.execute(ws1);
            executor.execute(ws2);
            executor.execute(ws3);

            System.out.println("All running");
            try{
                sleep(9000);
                printTotals();
            }
            catch (Exception e){
                System.out.println("FS: Sleep caused exception");
            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Tried to parse float from string with invalid format");
            e.printStackTrace();
        }
    }
    public static void printTotals(){
        System.out.println("P1: " +p1made);
        System.out.println("P2: " +p2made);
        System.out.println("P3: " +p3made);
    }
}
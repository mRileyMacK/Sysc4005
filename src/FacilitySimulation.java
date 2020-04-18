import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class FacilitySimulation {
    public static void main(String[] args) {
        WorkstationFactory wsFactory = new WorkstationFactory();
        try {
            Inspector1 insp1 = new Inspector1("historical-data/servinsp1.dat");
            Inspector2 insp2 = new Inspector2(
                    "historical-data/servinsp22.dat",
                    "historical-data/servinsp22.dat");
            Workstation ws1 = wsFactory.getWorkstation(WORKSTATION_TYPE.W1, "historical-data/ws1.dat");
            Workstation ws2 = wsFactory.getWorkstation(WORKSTATION_TYPE.W2, "historical-data/ws2.dat");
            Workstation ws3 = wsFactory.getWorkstation(WORKSTATION_TYPE.W3, "historical-data/ws3.dat");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Tried to parse float from string with invalid format");
            e.printStackTrace();
        }
    }
}
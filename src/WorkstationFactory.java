import java.io.FileNotFoundException;

public class WorkstationFactory {
    public Workstation getWorkstation(WORKSTATION_TYPE type, String dataPath, int iterations) throws FileNotFoundException {
        switch (type){
            case W1:
                return new Workstation1(dataPath, iterations);

            case W2:
                return new Workstation2(dataPath, iterations);

            case W3:
                return new Workstation3(dataPath, iterations);

        }
        return null;
    }
}

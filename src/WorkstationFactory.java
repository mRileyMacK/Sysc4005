import java.io.FileNotFoundException;

public class WorkstationFactory {
    public Workstation getWorkstation(WORKSTATION_TYPE type, String dataPath) throws FileNotFoundException {
        switch (type){
            case W1:
                return new Workstation1(dataPath);

            case W2:
                return new Workstation2(dataPath);

            case W3:
                return new Workstation3(dataPath);

        }
        return null;
    }
}

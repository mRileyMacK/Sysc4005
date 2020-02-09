public class WorkstationFactory {
    public Workstation getWorkstation(WORKSTATION_TYPE type){
        switch (type){
            case W1:
                return new Workstation1();

            case W2:
                return new Workstation2();

            case W3:
                return new Workstation3();

        }
        return null;
    }
}

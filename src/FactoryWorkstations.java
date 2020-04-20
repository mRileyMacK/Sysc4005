public class FactoryWorkstations {
    private Workstation1 w1;
    private Workstation2 w2;
    private Workstation3 w3;
    private int p1Tally;
    private int p2Tally;
    private int p3Tally;
    FactoryWorkstations(Workstation1 w1, Workstation2 w2, Workstation3 w3){
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        p1Tally = 0;
        p2Tally = 0;
        p3Tally = 0;
    }

    public Workstation1 getW1() {
        return w1;
    }

    public Workstation2 getW2() {
        return w2;
    }

    public Workstation3 getW3() {
        return w3;
    }
}

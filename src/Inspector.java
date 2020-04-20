import static java.lang.Thread.sleep;

public abstract class Inspector implements Runnable{
    protected ComponentFactory compFactory;
    protected FactoryWorkstations workstations;
    public static int ITERATIONS;
    public Inspector(FactoryWorkstations fw, int iterations){
        ITERATIONS = iterations;
        compFactory = new ComponentFactory();
        workstations = fw;
    }

    public abstract Component getNextComponent();
    public void inspect(){
        Component c = this.getNextComponent();
        System.out.println("the next component is "+ c.getNum());
        try{
            sleep(getNextCompTime(c).longValue());
            System.out.println("Inspector " + this.getNum() + " finished inspecting c" + c.getNum());

            Workstation w = passToBuffer(c);
            System.out.println("Passed component to " + w.getNum());
        }
        catch (Exception e){
            System.out.println("inspector " + this.getNum() + " failed with: " + e.toString());
        }
    }
    @Override
    public void run(){
        for(int i =0; i < ITERATIONS; i++){
            inspect();
        }
    }
    public abstract Workstation passToBuffer(Component c);
    protected abstract Float getNextCompTime(Component c);
    public abstract int getNum();
}
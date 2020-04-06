public class Workstation3 extends Workstation {
    private Buffer<Component3> c3Buffer;

    public Workstation3(){
        super("ws3.dat");
        c3Buffer = new Buffer<Component3>();
    }

    public Buffer<Component3> getC3Buffer() {
        return c3Buffer;
    }
}

import java.io.FileNotFoundException;

public class Workstation2 extends Workstation {
    private Buffer<Component2> c2Buffer;

    public Workstation2(String dataPath) throws FileNotFoundException {
        super(dataPath);
        c2Buffer = new Buffer<Component2>();
    }

    public Buffer<Component2> getC2Buffer() {
        return c2Buffer;
    }


}

import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;

public class Workstation2 extends Workstation {
    private Buffer<Component2> c2Buffer;

    public Workstation2(String dataPath, int iterations) throws FileNotFoundException {
        super(dataPath, iterations);
        c2Buffer = new Buffer<Component2>();
    }

    public Buffer<Component2> getC2Buffer() {
        return c2Buffer;
    }

    public int getNum(){return 2;}

    public Component2 getNextC2(){
        Component2 c2 = (Component2) getC2Buffer().getNextComponent();
        System.out.println("Worstation " + this.getNum() + " got component 2");
        return c2;
    }

    public Product buildProduct() {
        Component2 c2 = this.getNextC2();
        Component1 c1 = this.getNextC1();

        try{
            sleep(getNextProcTime().longValue());

        }
        catch(Exception e){
            System.out.println("WS2: sleep failed, product not made. Continuing");
            return null;
        }
        Product2 p2 = new Product2(c1, c2);
        System.out.println("W2: product2 made.");
        FacilitySimulation.p2made ++;
        return p2;
    }
}

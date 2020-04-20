import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;

public class Workstation3 extends Workstation {
    private Buffer<Component3> c3Buffer;

    public Workstation3(String dataPath, int iterations) throws FileNotFoundException {
        super(dataPath, iterations);
        c3Buffer = new Buffer<Component3>();
    }

    public Buffer<Component3> getC3Buffer() {
        return c3Buffer;
    }

    public Component3 getNextC3(){
        Component3 c3 = (Component3) getC3Buffer().getNextComponent();
        System.out.println("Worstation " + this.getNum() + " got component 3");
        return c3;
    }

    public Product buildProduct() {
        Component3 c3 = this.getNextC3();
        Component1 c1 = this.getNextC1();

        try{
            sleep(getNextProcTime().longValue());

        }
        catch(Exception e){
            System.out.println("WS3: sleep failed, product not made. Continuing");
            return null;
        }
        Product3 p3 = new Product3(c1, c3);
        System.out.println("W3: product3 made.");
        FacilitySimulation.p3made ++;
        return p3;
    }

    public int getNum(){return 3;}
}

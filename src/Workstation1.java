import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;

public class Workstation1 extends Workstation {

    public Workstation1(String dataPath, int iterations) throws FileNotFoundException {
        super(dataPath, iterations);
    }
    public int getNum(){return 1;}

    @Override
    public Product buildProduct() {
        Component1 c1 = this.getNextC1();

        try{
            sleep(getNextProcTime().longValue());

        }
        catch(Exception e){
            System.out.println("WS1: sleep failed, product not made. Continuing: "+ e.toString());
            return null;
        }
        Product1 p1 = new Product1(c1);
        System.out.println("W1: product1 made.");
        FacilitySimulation.p1made ++;
        return p1;

    }

}

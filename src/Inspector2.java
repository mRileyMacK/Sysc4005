import java.util.Random;

public class Inspector2 extends Inspector{
    private Random rd;

    public boolean isNextComp2(){
        return rd.nextBoolean();
    }

    public Component getNextComponent(){
        if(isNextComp2()){
            return compFactory.getComponent(COMPONENT_TYPE.C2);
        }
        else {
            return compFactory.getComponent(COMPONENT_TYPE.C3);
        }
    }

}

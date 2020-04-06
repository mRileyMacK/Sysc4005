public class Inspector1 extends Inspector{
    public Component getNextComponent(){
        return compFactory.getComponent(COMPONENT_TYPE.C1);
    }
    public void inspect(){
        Component cToInspect = getNextComponent();

    }

}

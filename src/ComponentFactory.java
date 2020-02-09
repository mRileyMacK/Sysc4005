public class ComponentFactory {

    public Component getComponent(COMPONENT_TYPE type){
        switch (type){
            case C1:
                return new Component1();

            case C2:
                return new Component2();

            case C3:
                return new Component3();

        }

        return null;
    }
}

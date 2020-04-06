public class InspectorFactory {
    public Inspector getInspector(INSPECTOR_TYPE i){
        switch(i){
            case I1:
                return new Inspector1();

            case I2:
                return new Inspector2();
        }
        return null;
    }
}

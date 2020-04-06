public abstract class Inspector{
    protected final static String c1InspTimes = "servinsp1.dat";
    protected final static String c2InspTimes = "servinsp22.dat";
    protected final static String c3InspTimes = "servinsp23.dat";
    protected ComponentFactory compFactory;

    public Inspector(){
        compFactory = new ComponentFactory();

    }

    public abstract Component getNextComponent();

}
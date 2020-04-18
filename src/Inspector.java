public abstract class Inspector{
    protected ComponentFactory compFactory;

    public Inspector(){
        compFactory = new ComponentFactory();
    }

    public abstract Component getNextComponent();
    public abstract void inspect(Component c);
}
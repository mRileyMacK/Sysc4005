public class Product2 extends Product{
    private Component2 c2;

    public Product2(Component1 c1, Component2 c2){
        super(c1);
        this.c2 = c2;
    }

    @Override
    public int getNum() {
        return 2;
    }
}
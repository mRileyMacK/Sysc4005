public class Product3 extends Product{
    private Component3 c3;
    public Product3(Component1 c1, Component3 c3){
        super(c1);
        this.c3 = c3;
    }

    @Override
    public int getNum() {
        return 3;
    }
}
package Lab5.Prob1;

public class MallardDuck extends Duck {
    public MallardDuck() {
        setQuackable(new Quack());
        setFlyable(new FlyWithWings());
    }
    @Override
    public void display() {
        System.out.println("display");

    }
}

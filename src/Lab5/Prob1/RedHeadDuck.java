package Lab5.Prob1;

public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        setQuackable(new Quack());
        setFlyable(new FlyWithWings());
    }
    @Override
    public void display() {
        System.out.println("displaying");
    }
}

package Lab5.Prob1;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setQuackable(new MuteQuack());
        setFlyable(new CannotFly());
    }
    @Override
    public void display() {
        System.out.println("displaying");
    }
}

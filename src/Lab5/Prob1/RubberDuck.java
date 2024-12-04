package Lab5.Prob1;

public class RubberDuck extends Duck{
    public RubberDuck() {
        setFlyable(new CannotFly());
        setQuackable(new Squeak());
    }
    @Override
    public void display() {
        System.out.println("displaying");
    }
}

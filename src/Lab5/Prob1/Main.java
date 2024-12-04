package Lab5.Prob1;

public class Main {
    public static void main(String[] args) {
        Duck[] ducks = {new MallardDuck(), new DecoyDuck(), new RubberDuck(), new RedHeadDuck()};
        for (Duck duck : ducks) {
            System.out.println(duck.getClass().getSimpleName() + ":");
            duck.display();
            duck.quack();
            duck.fly();
            duck.swim();
        }
    }
}

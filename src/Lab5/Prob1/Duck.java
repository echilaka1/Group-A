package Lab5.Prob1;

abstract public class Duck {
    private Flyable flyBehavior;
    private Quackable quackBehavior;

    public void quack() {
        quackBehavior.quack();
    }
    public void swim() {
        System.out.println("Swimming");
    }
    abstract public void display();
    public void fly() {
        flyBehavior.fly();
    }

    public void setFlyable(Flyable flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
    public void setQuackable(Quackable quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

}


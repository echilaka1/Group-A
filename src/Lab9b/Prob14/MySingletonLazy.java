public class MySingletonLazy {
    private static MySingletonLazy instance = null;

    private MySingletonLazy() {
    }

    private static MySingletonLazy getInstance() {
        instance = Optional.ofNullable(instance).orElseGet(MySingletonLazy::new);
        return instance;
    }

    public static void main(String[] args) {
        MySingletonLazy obj1 = new MySingletonLazy();
        MySingletonLazy obj2 = new MySingletonLazy();

        System.out.println(obj1.hashCode());
        System.out.println(obj1.hashCode());
    }
}
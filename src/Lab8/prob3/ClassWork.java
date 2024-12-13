package Lab8.prob3;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ClassWork {
    public static void main(String[] args) {

        Function<Apple, Double> getWeight1 = (Apple a) -> a.getWeight();
        Function<Apple, Double> getWeight2 = Apple::getWeight;
        // Method reference type: Class::instanceMethod

        Function<String, Integer> parseInt1 = (String x) -> Integer.parseInt(x);
        Function<String, Integer> parseInt2 = Integer::parseInt;
        // Method reference type: Class::staticMethod

        EmployeeNameComparator comp = new EmployeeNameComparator();
        BiFunction<Employee, Employee, Integer> compareEmployees1 = (Employee e1, Employee e2) -> comp.compare(e1, e2);
        BiFunction<Employee, Employee, Integer> compareEmployees2 = comp::compare;
        // Method reference type: instance::instanceMethod
    }
}

class Employee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Apple {
    private double weight;

    public double getWeight() {
        return weight;
    }
}

class EmployeeNameComparator {
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
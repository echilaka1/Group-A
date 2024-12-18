import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final Function<List<Employee>, Integer> EMPLOYEES_COUNT = (List<Employee> list) -> {
        return (int) list.stream()
                .filter(e -> e.getSalary() > 100000)
                .filter(e -> e.getLastName().charAt(0) > 'E')
                .count();
    };

    public static final Function<List<Employee>, List<String>> EMPLOYEE_LIST = (List<Employee> list) -> {
        return list.stream().filter(e -> e.getSalary() > 85000).filter(e -> e.getFirstName().charAt(0) < 'R')
                .map(e -> e.getFirstName() + " " + e.getLastName()).map(e -> e.toUpperCase()).sorted()
                .collect(Collectors.toList());
    };

}

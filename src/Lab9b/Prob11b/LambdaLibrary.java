import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final Function<List<Employee>, String> FILTERED_EMPLOYEES = emps -> emps.stream()
            .filter(e -> e.getSalary() > 100000)
            .filter(e -> e.getLastName().charAt(0) > 'M')
            .map(e -> e.getFirstName() + " " + e.getLastName()) // Use fullName logic inline
            .sorted()
            .collect(Collectors.joining(", "));
}

package prob3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	int salary;

	public Employee(String n, int s) {
		this.name = n;
		this.salary = s;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + salary + "]";
	}

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>() {
			{
				add(new Employee("Joe", 50000));
				add(new Employee("Jim", 75000));
				add(new Employee("Tom", 80000));
				add(new Employee("Jim", 70000));
				add(new Employee("Steve", 55000));
				add(new Employee("Jim", 100000));
				add(new Employee("Joe", 59000));
				add(new Employee("Rich", 88000));
			}
		};

		Comparator<Employee> byName = Comparator.comparing(Employee::getName);
		Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary).reversed();
		Comparator<Employee> byNameThenSalary = byName.thenComparing(bySalary);
		list.stream().sorted(byNameThenSalary).forEach(System.out::println);

		// or with direct comparator usage
		list.stream()
				.sorted(Comparator.comparing(Employee::getName)
						.thenComparing(Comparator.comparing(Employee::getSalary).reversed()))
				.forEach(System.out::println);

		// or with direct comparator usage 2
		list.stream()
				.sorted(Comparator.comparing(Employee::getName)
						.thenComparing(Employee::getSalary).reversed())
				.forEach(System.out::println);

		// expected output:
		// [Rich, 88000], [Steve, 55000], [Tom, 80000]]
		// System.out.println(/* implement */);
	}
}

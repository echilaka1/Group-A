package prob5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class EmployeeInfoOK {
	static enum SortMethod {
		BYNAME, BYSALARY
	};

	private final HashMap<SortMethod, Comparator<Employee>> sortByMapping;

	public EmployeeInfoOK() {

		sortByMapping = new HashMap<>();
		sortByMapping.put(SortMethod.BYNAME, Comparator.comparing(e -> e.getName()));
		sortByMapping.put(SortMethod.BYSALARY, Comparator.comparing(e -> e.getSalary()));
	}

	public void sort(List<Employee> emps, final SortMethod method) {
		emps.stream().sorted(sortByMapping.get(method)).forEach(System.out::println);
	}

	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Andy", 60000));
		EmployeeInfoOK ei = new EmployeeInfoOK();

		ei.sort(emps, EmployeeInfoOK.SortMethod.BYNAME);
		System.out.println("##############");
		ei.sort(emps, EmployeeInfoOK.SortMethod.BYSALARY);

		// i want to have a hashmap vairable thet has all supported sort methods,
		// indise the sort i will retreive the method from this map and mapped compartor

		// ei.sort(emps, EmployeeInfoOK.SortMethod.BYNAME);
		// System.out.println(emps);
		// // same instance
		// ei.sort(emps, EmployeeInfoOK.SortMethod.BYSALARY);
		// System.out.println(emps);

	}
}

package Lab7.prob2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		list.forEach(getUpperCaseConsumer());
		
	}
	
	public static String toUpper(String s) {
		return s.toUpperCase();
	}

	//implement a Consumer
	public static Consumer<String> getUpperCaseConsumer() {
		return s -> System.out.println(toUpper(s));
	}
}
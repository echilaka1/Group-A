package Lab3.Prob1;


public class Person {

	private String name;
	Person(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object aPerson) {
		if (aPerson == null) return false;
		if (!(aPerson instanceof Person)) return false;
		Person p = (Person) aPerson;
		return this.name.equals(p.name);
	}
	public static void main(String[] args) {
		Person person = new Person("Joe");
		Job job = new Job(person, 30000);

		Person personWithoutJob = new Person("Joe");

		// Check equality considering the Person object in Job
		System.out.println("job.equals(personWithoutJob)? " + job.equals(personWithoutJob));
		System.out.println("personWithoutJob.equals(job)? " + personWithoutJob.equals(job));
		
	}

}

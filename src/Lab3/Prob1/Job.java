package Lab3.Prob1;

public class Job {

        private Person person; // Composition
        private double salary;

        Job(Person p, double s) {
            person = p;
            salary = s;
        }

        public double getSalary() {
            return salary;
        }

        public Person getPerson() {
            return person;
        }

        @Override
        public boolean equals(Object anObject) {
            if (anObject == null) return false;

            // Check if the other object is a Job or a Person
            if (anObject instanceof Job) {
                Job otherJob = (Job) anObject;
                return this.person.equals(otherJob.person) && this.salary == otherJob.salary;
            } else if (anObject instanceof Person) {
                Person otherPerson = (Person) anObject;
                return this.person.equals(otherPerson);
            }
            return false;
        }
}

import java.util.ArrayList;
import java.util.List;

public class Persons implements Finder<Person> {
    private List<Person> people;

    public Persons() {
        people = new ArrayList<>();
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    // Find first person by name
    public Person findByName(String name) {
        return findOne(people, p -> p.getName().equals(name));
    }

    // Find all people older than a given age
    public List<Person> findOlderThan(int age) {
        return findAll(people, p -> p.getAge() > age);
    }

    // Count people older than a given age
    public long countOlderThan(int age) {
        return findNoOf(people, p -> p.getAge() > age);
    }

    // Sum of ages of people matching a condition
    public int sumOfAgesOlderThan(int age) {
        return findSumOf(people, p -> p.getAge() > age, Person::getAge);
    }

    public static void main(String[] args) {
        Persons persons = new Persons();
        persons.addPerson(new Person("Alice", 25));
        persons.addPerson(new Person("Bob", 30));
        persons.addPerson(new Person("Charlie", 20));
        persons.addPerson(new Person("David", 35));

        System.out.println("Find one by name 'Bob': " + persons.findByName("Bob"));
        System.out.println("Find all older than 22: " + persons.findOlderThan(22));
        System.out.println("Count older than 22: " + persons.countOlderThan(22));
        System.out.println("Sum of ages older than 22: " + persons.sumOfAgesOlderThan(22));
    }
}

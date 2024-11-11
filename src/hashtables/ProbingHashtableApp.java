package hashtables;

import entities.Employee;
import hashtables.hashtable.ProbingHashtable;

public class ProbingHashtableApp {
    public static void main(String[] args) {
        Employee jane = new Employee(0, "Jane", "Doe");
        Employee john = new Employee(1, "John", "Doe");
        Employee mary = new Employee(2, "Mary", "Smith");
        Employee luci = new Employee(3, "Luci", "Jones");
        Employee mike = new Employee(4, "Mike", "Wilson");
        Employee will = new Employee(5, "William", "Troublemaker");

        ProbingHashtable map = new ProbingHashtable(5);

        //Forcing the probe chain to break
        map.put(1, jane);
        map.put(6, john);
        map.put(2, mary);
        map.put(7, luci);
        map.put(3, mike);

        map.print();

        System.out.println("Removing John...");
        map.remove(6);

        map.print();

        System.out.println("Retrieved Employee: " + map.get(2));

        System.out.println("Retrieving removed employee (ID 6): " + map.get(6));
    }

}

package hashtables;

import entities.Employee;
import hashtables.util.SimpleHashtable;

public class HastableApp {
    public static void main(String[] args) {
        Employee jane = new Employee(0, "Jane", "Doe");
        Employee john = new Employee(1, "John", "Doe");
        Employee mary = new Employee(2, "Mary", "Smith");
        Employee luci = new Employee(3, "Luci", "Jones");
        Employee mike = new Employee(4, "Mike", "Wilson");

        SimpleHashtable map = new SimpleHashtable(10);
        map.put(0, jane);
        map.put(1, john);
        map.put(2, mary);
        map.put(2, luci);
        map.put(9, mike);

        map.print();

        Employee e = map.get(1);
        System.out.println("Retrieved Employee: " + e);

    }

}

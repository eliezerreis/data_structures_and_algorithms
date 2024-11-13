package queues;

import entities.Employee;
import queues.util.ArrayQueue;

public class ArrayQueueApp {
    public static void main(String[] args) {
        Employee jane = new Employee(0, "Jane", "Doe");
        Employee john = new Employee(1, "John", "Doe");
        Employee mary = new Employee(2, "Mary", "Smith");
        Employee luci = new Employee(3, "Luci", "Jones");
        Employee mike = new Employee(4, "Mike", "Wilson");

        ArrayQueue queue = new ArrayQueue(2);
        queue.add(jane);
        queue.add(john);
        queue.add(mary);
        queue.add(luci);
        queue.add(mike);

        queue.print();

        queue.remove();
        queue.print();

        Employee e = queue.peek();
        System.out.println("Retrieved Employee: " + e);

        queue.print();
    }

}

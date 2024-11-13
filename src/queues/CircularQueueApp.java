package queues;

import entities.Employee;
import queues.util.CircularQueue;

public class CircularQueueApp {
    public static void main(String[] args) {
        Employee jane = new Employee(0, "Jane", "Doe");
        Employee john = new Employee(1, "John", "Doe");
        Employee mary = new Employee(2, "Mary", "Smith");
        Employee luci = new Employee(3, "Luci", "Jones");
        Employee mike = new Employee(4, "Mike", "Wilson");

        CircularQueue queue = new CircularQueue(2);
        queue.add(jane);
        queue.add(john);
        queue.remove();
        queue.add(mary);
        queue.remove();
        queue.add(luci);
        queue.remove();
        queue.remove();
        queue.add(mike);
        queue.remove();

        queue.print();
    }

}

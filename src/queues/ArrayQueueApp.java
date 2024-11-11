package queues;

import entities.Employee;
import queues.queue.ArrayQueue;
import stacks.stack.EmployeeArrayStack;

public class ArrayQueueApp {
    public static void main(String[] args) {
        Employee jane = new Employee(0, "Jane", "Doe");
        Employee john = new Employee(1, "John", "Doe");
        Employee mary = new Employee(2, "Mary", "Smith");
        Employee luci = new Employee(3, "Luci", "Jones");
        Employee mike = new Employee(4, "Mike", "Wilson");

        ArrayQueue stack = new ArrayQueue(2);
        stack.add(jane);
        stack.add(john);
        stack.add(mary);
        stack.add(luci);
        stack.add(mike);

        stack.print();

        stack.remove();
        stack.print();

        Employee e = stack.peek();
        System.out.println("Retrieved Employee: " + e);

        stack.print();
    }

}

package stacks;

import entities.Employee;
import stacks.util.EmployeeLinkedStack;

public class StackLinkedListApp {
    public static void main(String[] args) {
        Employee jane = new Employee(0, "Jane", "Doe");
        Employee john = new Employee(1, "John", "Doe");
        Employee mary = new Employee(2, "Mary", "Smith");
        Employee luci = new Employee(3, "Luci", "Jones");
        Employee mike = new Employee(4, "Mike", "Wilson");

        EmployeeLinkedStack stack = new EmployeeLinkedStack();
        stack.push(jane);
        stack.push(john);
        stack.push(mary);
        stack.push(luci);
        stack.push(mike);

        stack.print();

        stack.pop();
        stack.print();

        Employee e = stack.peek();
        System.out.println("Retrieved Employee: " + e);

        stack.print();
    }

}

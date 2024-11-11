package stacks.stack;

import entities.Employee;
import lists.linked.EmployeeLinkedList;

import java.util.EmptyStackException;

public class EmployeeLinkedStack {
    private final EmployeeLinkedList stack;

    public EmployeeLinkedStack() {
        this.stack = new EmployeeLinkedList();
    }

    public void push(Employee employee) {
        this.stack.addToFront(employee);
    }

    public Employee pop() {
        return this.stack.removeFromFront();
    }

    public Employee peek() {
        return stack.getHead().getEmployee();
    }

    public void print() {
        stack.printList();
        System.out.println("------------------");
    }

}

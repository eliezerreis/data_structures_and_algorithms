package stacks;

import entities.Employee;

public class EmployeeArrayStack {
    private Employee[] stack;

    private int top;
    private int capacity;

    public EmployeeArrayStack(int capacity) {
        this.stack = new Employee[capacity];
        this.capacity = capacity;
    }

    public void push(Employee employee) {
        if (top == capacity) {
            Employee[] newStack = new Employee[capacity * 2];
            System.arraycopy(stack, 0, newStack, 0, capacity);

            stack = newStack;
            capacity *= 2;
        }

        stack[top++] = employee;
    }

    public Employee pop() {
        Employee employee = peek();

        stack[top - 1] = null;
        top--;

        return employee;
    }

    public Employee peek() {
        if (top <= 0) return null;

        return stack[top - 1];
    }

    public void print() {
        for (int i = 0; i < top; i++) {
            System.out.println(stack[i]);
        }
        System.out.println("------------------");
    }

}

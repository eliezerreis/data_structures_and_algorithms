package queues.queue;

import entities.Employee;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayQueue {
    private Employee[] queue;
    private int back;
    private int front;

    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (back == queue.length) {
            Employee[] newStack = new Employee[capacity * 2];
            System.arraycopy(queue, 0, newStack, 0, capacity);

            queue = newStack;
            capacity *= 2;
        }

        queue[back++] = employee;
    }

    public Employee remove() {
        Employee employee = peek();
        back--;
        front++;

        //If we remove the only item in the queue
        if (size() == 0) {
            front = 0;
            back = 0;
            queue = new Employee[capacity];
        }


        return employee;
    }

    public Employee peek() {
        // Queue is empty
        if (size() == 0) throw new NoSuchElementException();

        return queue[front];
    }

    public int size() {
        return back - front;
    }


    public void print() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
        System.out.println("------------------");
    }

}

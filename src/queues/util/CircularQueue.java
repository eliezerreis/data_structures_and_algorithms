package queues.util;

import entities.Employee;

import java.util.NoSuchElementException;

public class CircularQueue {
    private Employee[] queue;
    private int back;
    private int front;

    private final int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (size() == queue.length - 1) {
            int currentSize = size();
            Employee[] newQueue = new Employee[queue.length * 2];
            System.arraycopy(queue, front, newQueue, 0, queue.length - front);
            System.arraycopy(queue, 0, newQueue, queue.length - front, back);
            queue = newQueue;

            front = 0;
            back = currentSize;
        }

        queue[back] = employee;

        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }

    }

    public Employee remove() {
        Employee employee = peek();
        front++;

        //If we remove the only item in the queue
        if (size() == 0) {
            front = 0;
            back = 0;
            queue = new Employee[capacity];
        } else if (front == queue.length) {
            front = 0;
        }


        return employee;
    }

    public Employee peek() {
        // Queue is empty
        if (size() == 0) throw new NoSuchElementException();

        return queue[front];
    }

    public int size() {
        if (front <= back)
            return back - front;
        else
            return back - front + queue.length;
    }

    public void print() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        System.out.println("------------------");
    }

}

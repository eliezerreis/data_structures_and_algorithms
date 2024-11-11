package lists.linked;

import lists.entities.Employee;

public class EmployeeDoublyLinkedList {
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        if (head != null)
            head.setPrevious(node);
        else
            tail = node;

        node.setNext(head);
        node.setPrevious(null); // Always null, just to make it clear.

        head = node;
        size++;
    }

    public void addToBack(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        if (tail != null)
            tail.setNext(node);
        else
            head = node;

        node.setNext(null);
        node.setPrevious(tail);

        tail = node;
        size++;
    }

    public void removeFromFront() {
        if (isEmpty()) return;

        EmployeeNode node = head;
        head = head.getNext();

        // If last element on the list
        if (head != null)
            head.setPrevious(null);
        else
            tail = null;

        node.setNext(null);
        node.setPrevious(null);
        size--;
    }

    public void removeFromBack() {
        if (isEmpty()) return;

        EmployeeNode node = tail;
        tail = tail.getPrevious();

        // If last element on the list
        if (tail != null)
            tail.setNext(null);
        else
            head = null;

        node.setPrevious(null);
        node.setNext(null);
    }

    public void printList() {
        EmployeeNode current = head;
        while (current != null) {
            System.out.println(current.getEmployee());
            current = current.getNext();

        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }
}

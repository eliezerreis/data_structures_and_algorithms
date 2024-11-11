package lists.linked;

import entities.Employee;

public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;

        size++;
    }

    public Employee removeFromFront() {
        if (isEmpty()) return null;

        EmployeeNode node = head;
        head = head.getNext();
        size--;

        node.setNext(null);

        return node.getEmployee();
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
        return head == null;
    }

    public EmployeeNode getHead() {
        return head;
    }
}

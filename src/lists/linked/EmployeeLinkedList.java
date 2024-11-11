package lists.linked;

import lists.entities.Employee;

public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;
    private boolean empty;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;

        size++;
    }

    public void removeFromFront() {
        if (isEmpty()) return;

        EmployeeNode node = head;
        head = head.getNext();
        size--;

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
        return head == null;
    }
}

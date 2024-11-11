package lists;

public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;
    private boolean empty;

    void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;

        size++;
    }

    Employee removeFromFront() {
        if (isEmpty())
            return null;

        EmployeeNode node = head;
        head = head.getNext();
        size--;

        node.setNext(null);
        return node.getEmployee();
    }


    void printList() {
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

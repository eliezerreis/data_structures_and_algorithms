package lists;

import entities.Employee;
import lists.util.EmployeeDoublyLinkedList;

public class DoublyListApp {
    /**
     * Pros:
     * 1) Very good when you have to insert elements in the front of the list
     * 2) It grows accordingly without being resizes
     * Cons:
     * 1) Extra fields for next, node and so on
     */
    public static void main(String[] args) {
        Employee e1 = new Employee(0, "Jane", "Doe");
        Employee e2 = new Employee(1, "John", "Doe");
        Employee e3 = new Employee(2, "Mary", "Smith");
        Employee e4 = new Employee(3, "Luci", "Jones");
        Employee e5 = new Employee(4, "Mike", "Wilson");


        EmployeeDoublyLinkedList linkedList = new EmployeeDoublyLinkedList();
        linkedList.addToFront(e1);
        linkedList.addToFront(e2);
        linkedList.addToFront(e3);
        linkedList.addToBack(e4);
        linkedList.addToBack(e5);

        linkedList.printList();
        System.out.println("Is the list empty? " + linkedList.isEmpty());
        System.out.println("Size of the list: " + linkedList.getSize());

        System.out.println("Remove to the front");
        linkedList.removeFromFront();
        linkedList.printList();

        System.out.println("Remove to the back");
        linkedList.removeFromBack();
        linkedList.printList();

    }

}

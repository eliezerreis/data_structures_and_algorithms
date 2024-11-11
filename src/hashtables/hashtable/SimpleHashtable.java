package hashtables.hashtable;

import entities.Employee;

public class SimpleHashtable {
    Employee[] map;

    public SimpleHashtable(int capacity) {
        map = new Employee[capacity];
    }

    private int hashKey(int id) {
        return id % map.length;
    }

    public void put(int key, Employee e) {
        int hashedKey = hashKey(key);

        if (map[hashedKey] != null) {
            System.out.println("Collision occurred at index " + hashedKey);
            return;
        }

        map[hashedKey] = e;
    }

    public Employee get(int key) {
        return map[hashKey(key)];
    }

    public void print() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(map[i]);
        }
        System.out.println("------------------");
    }

}



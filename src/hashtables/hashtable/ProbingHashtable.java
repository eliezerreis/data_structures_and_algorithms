package hashtables.hashtable;

import entities.Employee;

public class ProbingHashtable {
    Store[] map;

    public ProbingHashtable(int capacity) {
        map = new Store[capacity];
    }

    private int hashKey(int rawKey) {
        return rawKey % map.length;
    }

    public void put(int key, Employee employee) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) {
            //Collision detected at the current index

            int stopIndex = hashedKey;

            // Don't allow to insert existing keys
            while (isOccupied(hashedKey)) {
                hashedKey = (hashedKey + 1) % map.length; // Wrap around if necessary
                if (hashedKey == stopIndex) {
                    System.out.println("Table is full. Could not insert the employee.");
                    return;
                }
            }
        }

        map[hashedKey] = new Store(key, employee);
    }

    public Employee get(int key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1 || map[hashedKey] == null) return null;

        return map[hashedKey].getEmployee();
    }


    public Employee remove(int key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1 || map[hashedKey] == null) return null;

        Store item = map[hashedKey];
        map[hashedKey].delete();

        return item.getEmployee();
    }

    public void print() {
        for (Store store : map) {
            System.out.println(store);
        }
        System.out.println("------------------");
    }


    private boolean isOccupied(int hashedKey) {
        return map[hashedKey] != null;
    }


    private int findKey(int key) {
        int hashedKey = hashKey(key);
        int stopIndex = hashedKey;

        while (map[hashedKey] != null) {

            // If the key matches, return the index
            if (map[hashedKey].getKey() == key && !map[hashedKey].isDeleted()) {
                return hashedKey;
            }

            hashedKey = (hashedKey + 1) % map.length;

            // If we've checked all positions, stop
            if (hashedKey == stopIndex) {
                break;
            }
        }

        // if we couldn't find the key return -1
        return -1;
    }

}



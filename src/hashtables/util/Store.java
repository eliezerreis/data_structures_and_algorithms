package hashtables.util;

import entities.Employee;

public class Store {
    private final int key; // This save the hashed key used to save the employee
    private Employee employee;

    private boolean deleted;

    public Store(int key, Employee employee) {
        this.key = key;
        this.employee = employee;
        this.deleted = false;
    }

    @Override
    public String toString() {
        return "Store{" + " key=" + key + ", employee=" + employee + (deleted ? ", deleted" : "") + '}';
    }

    public int getKey() {
        return key;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void delete() {
        this.deleted = true;
    }

}


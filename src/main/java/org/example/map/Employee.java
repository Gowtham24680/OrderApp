package org.example.map;

public class Employee {
    private final int id;
    private final String name;
    private final boolean forceSameHash;

    public Employee(int id, String name, boolean forceSameHash) {
        this.id = id;
        this.name = name;
        this.forceSameHash = forceSameHash;
    }

    @Override
    public int hashCode() {
        return forceSameHash ? 1 : id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

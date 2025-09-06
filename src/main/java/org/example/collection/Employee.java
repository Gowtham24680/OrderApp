package org.example.collection;

import java.util.Date;

public class Employee {
    private String id;
    private String name;
    private long date;
    private double salary;
    public Employee(String id, String name, Date date, double salary) {
        this.id = id;
        this.name = name;
        this.date = date.getTime();
        this.salary = salary;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDate(long date) {
        this.date = date;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDate() {
        return String.valueOf(date);
    }
    public String getSalary() {
            return String.valueOf(salary);
        }
        public String toString() {
            return "Employee [id=" + id + ", name=" + name + ", date=" + date + ", salary=" + salary + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Employee other = (Employee) obj;
            return id.equals(other.id);
        }
        public int hashCode() {
            return id.hashCode();
        }


}

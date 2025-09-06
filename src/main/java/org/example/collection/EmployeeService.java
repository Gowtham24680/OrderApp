package org.example.collection;

import java.util.HashSet;
import java.util.Set;

public class EmployeeService {
    public Set<Employee> getEmployees() {
        Set<Employee> employee = new HashSet<>();
        employee.add(new Employee("1", "John", new java.util.Date(), 50000));
        employee.add(new Employee("2", "Jane", new java.util.Date(), 60000));
        employee.add(new Employee("3", "Alice",new java.util.Date() , 55000));
        employee.add(new Employee("4", "Bob", new java.util.Date(), 70000));
        employee.add(new Employee("4", "Bob",new java.util.Date() , 70000));

        return employee;
    }





}

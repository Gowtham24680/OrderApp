package org.example.collection;

import java.util.Set;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeService employee = new EmployeeService();
        Set<Employee> employees = employee.getEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);

    }
        }
        }


package org.example.map;

import java.util.Map;

public class EmployeeServiceTest {
    public static void main(String[] args) {
        int n = 1_000_000; // 1M Employees
        EmployeeService service = new EmployeeService();

        // Case 2: Same hashCodes
        Map<Employee, String> collisionMap = service.buildEmployeeMap(n, false);
        double collisionTime = service.measureLookupTime(collisionMap, n, false);
        System.out.println("Same hashCode lookup time: " + collisionTime + " ms");

        // Case 1: Unique hashCodes
        Map<Employee, String> normalMap = service.buildEmployeeMap(n, false);
        double uniqueTime = service.measureLookupTime(normalMap, n, false);
        System.out.println("Unique hashCode lookup time: " + uniqueTime + " ms");
    }
}

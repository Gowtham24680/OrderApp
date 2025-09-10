package org.example.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeService {

    public Map<Employee, String> buildEmployeeMap(int n, boolean forceSameHash) {
        return IntStream.range(0, n).boxed()
                .collect(Collectors.toMap(
                        i -> new Employee(i, "Emp" + i , forceSameHash),
                        i -> "Value" + i,
                        (v1, v2) -> v1,
                        () -> new HashMap<>(16, 0.75f) // small capacity → list mode
                ));
    }

    public double measureLookupTime(Map<Employee, String> map, int n, boolean forceSameHash) {
        Employee searchKey = new Employee(n - 1, "Emp" + (n - 1), forceSameHash);
        long start = System.nanoTime();
        String result = map.get(searchKey);
        long end = System.nanoTime();

        if (result == null) {
            throw new RuntimeException("Lookup failed! Key not found.");
        }

        System.out.println("Retrieved employee: " + result);

        return (end - start) / 1_000_000.0; // convert ns → ms
    }
}

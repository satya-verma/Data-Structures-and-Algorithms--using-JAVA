package dynamic_programming.dynamic_fibonacci;

import java.util.HashMap;

public class DynamicFibonacci {
    static HashMap<Integer, Integer> cache = new HashMap<>();
    static int operationsCount = 0;

    public int fibonacciMaster(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            if (n < 2) {
                return n;
            } else {
                operationsCount++;
                cache.put(n, fibonacciMaster(n - 1) + fibonacciMaster(n - 2));
                return cache.get(n);
            }
        }
    }

    public static void main(String[] args) {
        DynamicFibonacci fib = new DynamicFibonacci();
        System.out.println(fib.fibonacciMaster(30));
        System.out.println(operationsCount);
    }
}

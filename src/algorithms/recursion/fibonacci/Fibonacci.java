package algorithms.recursion.fibonacci;

// Given a number N return the index value of the Fibonacci sequence,
// where the sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...

// the pattern of the sequence is that each value is the sum of the
// 2 previous values, that means that for N=5 → 2+3

//For example: fibonacciRecursive(6) should return 8

public class Fibonacci {
    // iterative
    public int fibonacciIterative(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int[] arr = {1, 1};
            for (int i = 3; i <= n; i++) {
                int temp = arr[1];
                arr[1] = arr[0] + arr[1];
                arr[0] = temp;
            }
            return arr[1];
        }
    }

    // recursive
    public int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacciIterative(5));
        System.out.println(fibonacci.fibonacciRecursive(5));
    }
}

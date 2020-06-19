package algorithms.recursion.factorial;

// Write two functions that finds the factorial of any number.
// One should use recursive, the other should just use a for loop

//ex: 5! = 5 * 4 * 3 * 2 * 1
// or 5! = 5 * 4! and so on

public class Factorial {
    // recursive
    public int findFactorialRecursive(int number) {
        if (number < 2) {
            return 1;
        }
        return number * findFactorialIterative(number - 1);
    }

    // iterative
    public int findFactorialIterative(int number) {
        if (number < 2) {
            return 1;
        } else {
            int answer = 1;
            for (int i = 2; i <= number; i++) {
                answer *= i;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.findFactorialIterative(5));
        System.out.println(factorial.findFactorialRecursive(5));
    }
}

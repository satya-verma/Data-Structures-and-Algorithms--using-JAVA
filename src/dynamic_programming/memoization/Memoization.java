package dynamic_programming.memoization;

import java.util.HashMap;

public class Memoization {
    public int addTo80(int n) {
        System.out.println("long time");
        return n + 80;
    }

    static HashMap<Integer, Integer> cache = new HashMap<>();

    public int memoizeAddTo80(int n) {
        // once cached it won't have to add every time the function is called.
        if (!cache.containsKey(n)) {
            System.out.println("long time");
            cache.put(n, n + 80);
        }
        return cache.get(n);
    }

    public static void main(String[] args) {
        Memoization memo = new Memoization();
        System.out.println("addTo80: " + memo.addTo80(5));
        System.out.println("addTo80: " + memo.addTo80(5));

        System.out.println("memoizeAddTo80: " + memo.memoizeAddTo80(5));
        System.out.println("memoizeAddTo80: " + memo.memoizeAddTo80(5));
        System.out.println("memoizeAddTo80: " + memo.memoizeAddTo80(5));
    }
}

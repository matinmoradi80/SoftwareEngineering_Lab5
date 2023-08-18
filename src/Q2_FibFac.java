import java.util.HashMap;

public class Q2_FibFac {

    private static HashMap<Integer, Long> fib_cache = new HashMap<>();
    public static long fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (fib_cache.containsKey(n)) {
            return fib_cache.get(n);
        }
        long result = fib(n - 1) + fib(n - 2);
        fib_cache.put(n, result);
        return result;
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int m = 25;
        System.out.println("Factorial(" + m + ") = " + factorial(m));

        int n = 45;
        System.out.println("Fib(" + n + ") = " + fib(n));
    }
}

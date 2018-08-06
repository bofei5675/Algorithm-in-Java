package DynamicProgramming;

public class Fibonacci {
    public static int fib(int n) {
        if (n < 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static int fibDp(int n) {
        int[] fibRes = new int[n + 1];
        fibRes[0] = 1;
        fibRes[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            fibRes[i] = fibRes[i - 1] + fibRes[i - 2];

        }
        return fibRes[fibRes.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fibDp(3));
    }

}

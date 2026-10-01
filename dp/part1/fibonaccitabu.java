package dp.part1;

import java.util.*;

public class fibonaccitabu {//O(n)

    public static int fib(int n, int f[]) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (f[n] != 0) {
            return f[n];
        }

        f[n] = fib(n - 1, f) + fib(n - 2, f);

        return f[n];
    }

    public static int fibTabulation(int n) {
        int f[] = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int f[] = new int[n + 1];

        System.out.println("Fibonacci number = " + fibTabulation(n));

        sc.close();
    }
}
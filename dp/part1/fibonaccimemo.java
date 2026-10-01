// package dp.part1;

// public class fibonacci {
//     public static int fib(int n , int f[]){
//         if(n==0 || n ==1){
//             return n;
//         }
//         if(f[n]!=0){
//             return f[n];
//         }
//         f[n] = fib(n-1,f) + fib(n-2,f);
//         return f[n];
//     }
//     public static void main(String args[]){
//         int n = 5 ;
//         int f [] = new int [n+1];
//         System.out.println(fib(n,f));
//     }
// }
package dp.part1;

import java.util.*;

public class fibonaccimemo {//O(n)

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

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int f[] = new int[n + 1];

        System.out.println("Fibonacci number = " + fib(n, f));

        sc.close();
    }
}
package recursion;

public class fibonacci {
    public static int fib(int n){
        if (n==0 || n ==1){
            return n;
        }
        int fibm1= fib(n-1);
        int fibm2= fib(n-2);
        int fibn = fibm1+fibm2;
        return fibn;
    }
    public static void main (String args[]){
        int n = 25;
        System.out.println(fib(n));
    }
}

package recursion;

public class sum {
    public static int sum (int n){
        if(n==0){
            return 1;
        }
        int sum1 = sum(n-1);
        int sum  = n + sum1;
        return sum;
    }
    public static void main (String args[]){
        int n = 5;
        System.out.println(sum(n));

    }
}

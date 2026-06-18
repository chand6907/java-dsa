package bits;

public class clearbitsinrange {
    public static int clearbitsinrange(int n , int i , int j){
        int a = (~0) << (j+1);
        int b = (1<<i) - i;
        int bitmask = a | b;
        return n & bitmask ;

    }

    public static void main (String args[]){
        int n = 10;
        int i = 2;
        int j = 4;
        System.out.println(clearbitsinrange(n, i, j));
    }
}

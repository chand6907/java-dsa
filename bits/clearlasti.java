package bits;

public class clearlasti {
    public static int clearlasti(int n, int i){
        int bitmask = (~0) << i ;
        return n & bitmask;
    }
    public static void main(String args[]){
        int n = 15;
        int i = 2;
        System.out.println(clearlasti(n, i));
    }
}

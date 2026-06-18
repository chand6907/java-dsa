package bits;
public class updateith {

     public static int clearith(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static int updateith(int n , int i , int newbit){

        
        n = clearith(n,i);
        int bitmask = newbit << i;
        return n | bitmask ;
    }
    public static void main(String args[]){
        int n = 10;
        int i = 2;
        int newbit = 1;
        System.out.println(updateith(n, i, newbit));
    }
}
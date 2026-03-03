package recursion;
public class decreasingnumber{
    public static void printDec(int n){
        if(n==0){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    public static void main (String args[]){
        int n = 7;
        printDec(n);
    }
}
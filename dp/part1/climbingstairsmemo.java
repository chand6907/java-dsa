package dp.part1;
import java.util.*;
public class climbingstairsmemo {//O(n)
    
    public static int countways(int n,int ways[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(ways[n]!=-1){
            return ways[n];
        }

        ways[n]=  countways(n-1,ways)+countways(n-2,ways);
        return ways[n];
    }

    public static void main(String args[]){
        // int n = 5 ;

        Scanner sc = new Scanner (System.in);
        System.out.print("Enter n: ");

        int n = sc.nextInt();

        int ways []= new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println("Number of ways = "+countways(n,ways));
    }
}

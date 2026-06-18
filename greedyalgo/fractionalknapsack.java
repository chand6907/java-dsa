package greedyalgo;
import java.util.*;
public class fractionalknapsack {
    
    public static void main (String args[]){
        int val[] = {60,100,120};
        int wt[] = {10,20,30};
        int W = 50;

        double ratio[][]=  new double[val.length][2];
        for(int i = 0; i<val.length ; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)wt[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); //Collections.reverseOrder());

    int capacity = W;
    int finalValue = 0;

    for (int i = ratio.length-1;i>=0;i--){
        int idx =(int)ratio[i][0];
        if(wt[idx]<=capacity){
            finalValue += val[idx];
            capacity -= wt[idx];
    }
        else{
            finalValue += ratio[i][1]*capacity;
            capacity = 0;
            break;
        }


    }
    System.out.println("Maximum value in Knapsack = " + finalValue);
    }
}

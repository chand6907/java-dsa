package arraylist;

import java.util.ArrayList;
public class pairsum1 {

    // public static int[] pairSum1(ArrayList<Integer>List, int target){
    //     for (int i = 0 ; i < List.size();i++){
    //         for(int j = 0 ; j<List.size();j++){
    //             if(List.get(i)+List.get(j)==target){
    //                 // return true;
    //                 return new int []{i,j};

    //             }
    //         }

    //     }
    //     // return false;
    //     return new int []{-1,-1};
    // }

    public static boolean pairsum1(ArrayList<Integer>List, int target ){
        int lp = 0;
        int rp = List.size()-1;

        while(lp   != rp){
     if (List.get(lp)+List.get(rp)==target){
        return true;
     }
     else if (List.get(lp)+List.get(rp)<target){
        lp++;
     }
     else{
        rp--;
     }
        }
        return false;       
     }


    public static void main (String args[]){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int target = 5;

        // int result[]=pairSum1(list,target);
        // if(result[0]==-1){
        //     System.out.println("No pair found");
        // }else{
        //     System.out.println("Pair found at indices: "+result[0]+" and "+result[1]);
        // }



        System.out.println(pairsum1(list,target));

    }
}


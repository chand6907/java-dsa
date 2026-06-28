package hashing;
import java.util.*;
public class majorityelement {//O(n)
    
    public static void main(String args[]){
        int arr [] = { 1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int i = 0 ; i <arr.length;i++){
            // if(map.containsKey(arr[i])){
            //     map.put(arr[i],map.get(arr[i])+1);
            // }else{
            //     map.put(arr[i],1);
            // }
            //instead of the above given if condition code we can write this as a 

            map.put(arr[i],map.getOrDefault(arr[i],0 )+1);
        }

        // Set<Integer> KeySet = map.keySet();
        for (Integer    Key:map.keySet() ) {
            if(map.get(Key)>arr.length/3){
                System.out.println(Key);
            }
        }
    }
}

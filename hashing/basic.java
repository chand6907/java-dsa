package hashing;
import java.util.*;
public class basic {
    
    public static void main (String args[]){

        HashMap<String,Integer> hm = new HashMap<>();

        hm.put("India",100);
        hm.put("china",150);
        hm.put("us",50);

        System.out.println(hm); 

        //get0(1)
        int population = hm.get ("India");
        System.out.println(population);

        System.out.println(hm.get("indionesia"));//null

        //contains kkey(TorF)
        //O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indionesia"));

        //remove
        //o(1)
        System.out.println(hm.remove("china"));
        System.out.println(hm.remove("Indionesia"));

        System.out.println(hm);
        //size
        System.out.println(hm.size());
        //isEmpty

        System.out.println(hm.isEmpty());

        //clear to make make map clear
        // hm.clear();
        // System.out.println(hm.isEmpty());


    }
}

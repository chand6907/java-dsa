package hashing;
import java.util.*;
public class iteration {
    
    public static void main (String args[]){
        HashMap<String ,Integer>hm = new HashMap<>();
        hm.put("India",100);
        hm.put("china",150);
        hm.put("us",100);
        hm.put("Indionesia",6);
        hm.put("Nepal",5);

        //iterate
        //we can also use the hm.entrySet()

        Set <String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
                System.out.println("key="+k+",value="+hm.get(k));
        }
    }
}


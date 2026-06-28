package hashing;
import java.util.*;
public class linkedhashmap {
    

    public static void main(String args[]){
        LinkedHashMap<String , Integer> lhm = new LinkedHashMap<>();
        lhm.put("Inida",100);
        lhm.put("china",150);
        lhm.put("us",77);

        System.out.println(lhm);
    }
}

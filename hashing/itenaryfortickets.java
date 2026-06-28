package hashing;
import java.util.*;
public class itenaryfortickets {

    public static String getstart(HashMap<String ,String >tickets){
        HashMap<String ,String> revmap = new HashMap<>();

        for(String key : tickets.keySet()){
            revmap.put(tickets.get(key),key);
        }

        for(String key : tickets.keySet()){
            if(!revmap.containsKey(key)){
                return key;//starting point
            }
        }
        return null;//no need just to handle syntax error
    }
    public static void main (String args[]){
        HashMap<String , String >tickets = new HashMap<>();

        tickets.put("chennai","bengaluru");
        tickets.put("mumbai","delhi");
        tickets.put("goa","chennai");
        tickets.put("delhi","goa");

        String start = getstart(tickets);
        System.err.println(start);
         
        for (String key: tickets.keySet()){
            System.out.println("->"+tickets.get(start));
            start = tickets.get(start);
        }
        // System.out.println();
    }
}

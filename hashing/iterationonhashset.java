package hashing;
import java.util.*;
public class iterationonhashset {
    
    public static void main(String args[]){
        HashSet<String> cities = new HashSet<>();

        cities.add("delhi");
        cities.add("mumbai");
        cities.add("bengaluru");
        cities.add("Noida");

        
        //using iterator
        Iterator it = cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        //using enhanced for loop
        for(String city : cities){
            System.out.println(city);
        }
    }
}

package hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class linkedhashset {
        public static void main(String args[]){
        HashSet<String> cities = new HashSet<>();

        cities.add("delhi");
        cities.add("mumbai");
        cities.add("bengaluru");
        cities.add("Noida");

        System.out.println(cities);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();//it will give tihngs by insertion order
        lhs.add("delhi");
        lhs.add("mumbai");
        lhs.add("bengaluru");
        lhs.add("Noida");

        System.out.println(lhs);

    }
}

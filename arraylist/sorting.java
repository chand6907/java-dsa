package arraylist;
import java.util.*;

public class sorting {
    public static void main(String args[]){
        ArrayList<Integer>List = new ArrayList<>();
        List.add(5);
        List.add(2);
        List.add(8);
        List.add(1);
        System.out.println(List);

    Collections.sort(List);
    System.out.println(List);

    Collections.sort(List , Collections.reverseOrder());
    System.out.println(List);

    }
}

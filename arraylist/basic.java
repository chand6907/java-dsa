package arraylist;
import java.util.ArrayList;

public class basic {
    public static void main(String args[]){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        System.out.println(list.get(1));
        list.set(1, 10);
        System.out.println(list);
        list.add(1, 20);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());

        for(int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i)+ " ");


        }
            System.out.println();



    }
}

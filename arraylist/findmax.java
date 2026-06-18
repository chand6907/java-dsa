package arraylist;
import java.util.ArrayList;

public class findmax {
    public static void main(String args[]){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(9);
        list.add(7);    
        list.add(16);
        list.add(18);

        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i< list.size();i++){
            if(max<list.get(i)){
                max = list.get(i);
            }
        }
        System.out.println(max);

    }
}

package heap;
import java.util.PriorityQueue;
public class heap {
    
    public static void main (String args[]){
        PriorityQueue<Integer>pq=new PriorityQueue<>();//compartor.reverseoder()-> as in order to reverse the priorityor order

        pq.add(3);//o(logn)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());//o(1)
            pq.remove();//o(logn)
        }
    }
}

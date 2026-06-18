package queue;
import java.util.*;

public class deque {
    

    public static void main(String args[]){
        
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);
        dq.addLast(4);
        dq.addLast(5);
        dq.addLast(6);
        System.out.println(dq); 
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq);
    }
}


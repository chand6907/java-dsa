package queue;
import java.util.*;
public class stackusingdeque {

    static class stack{
        Deque<Integer> dq = new LinkedList<>();

        public void push (int data){
            dq.addLast(data);
        }

        public int pop()  {
            return dq.removeLast();
        }

        public int peek() {
            return dq.getLast();
        }

    }
    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);      
        s.push(2);
        s.push(3);  

        System.out.println(s.peek());
        System.err.println("Popped element: " + s.pop());
        System.err.println("Popped element: " + s.pop());
        System.err.println("Popped element: " + s.pop());
       
    }
} 
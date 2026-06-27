package heap;
import java.util.PriorityQueue;
public class object {

        static class student implements Comparable<student>{//@Override
        String name;
        int rank;

        public student(String name , int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(student s2){
            return this.rank -s2.rank;
        }
    }

    
    public static void main (String args[]){
        PriorityQueue<student>pq=new PriorityQueue<>();//compartor.reverseoder()-> as in order to reverse the priorityor order

        pq.add(new student ("a",4));
        pq.add(new student ("b",5));
        pq.add(new student ("c",2));
        pq.add(new student ("d",12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+" ->"+pq.peek().rank);//o(1)
            pq.remove();//o(logn)
        }
    }
}

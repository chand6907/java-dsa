package heap;
import java.util.*;
public class slidingwindow {
    

    static class pair implements Comparable<pair>{
        int val;
        int idx;

        public pair(int val , int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(pair p2){
            //ascending
            //return this.val - p2.val;
            //descending 
            return p2.val -this.val;
        }
    }
    public static void main (String args[]){//O(nlogk) it was more sufficent with deque     
        int arr []= {1,3,-1,-3,5,3,6,7};
        int k = 3;//window size
        int res[]=new int[arr.length-k+1];//result array = n-k+1

        PriorityQueue<pair> pq = new PriorityQueue<>();

        //1st window
        for(int i = 0 ; i <k ; i++){
            pq.add(new pair(arr[i],i));
        }
        res[0]=pq.peek().val;

        for (int i = k ; i<arr.length;i++){
            while(pq.size()>0 && pq.peek().idx<=(i-k)){
                    pq.remove();
            }
            pq.add(new pair(arr[i],i));
            res [i-k+1]=pq.peek().val;
        }

        for(int i = 0 ; i < res.length ; i++){
            System.out.println(res[i]+" ");
        }
        System.out.println();

    }
}

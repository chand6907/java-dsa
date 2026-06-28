package hashing;
import java.util.*;
public class hashmapcode {
    static class HashMap<K,V>{//k , v are generics
        private class Node{

            private int size;
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n  ;//n
        private int N;
        private LinkedList<Node>buckets[];//N=bucket.length

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N= 4;
            this.buckets = new LinkedList[4];
            for (int i = 0 ; i < 4 ;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }

        private int hashfunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%N;
        }

        private int searchfunction(K key, int bi){
            LinkedList<Node>ll = buckets[bi];
            int di = 0 ;

            for (int i = 0 ; i < ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node>oldbucket[]=buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;

            for (int i = 0 ; i < buckets.length ;i++){
                LinkedList <Node> ll = oldbucket[i];
                for(int j= 0 ; j < ll.size();j++){
                    Node node = ll.remove();
                    put(node.key,node.value); 
                }
            }
        }
        public void put (K key,V value){//O(lamda)
            int bi = hashfunction(key);
            int di = searchfunction(key,bi);

            if(di !=  -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node (key,value));
                n++;
            }

            double lamda = (double )n/N;
            if(lamda>2.0){
                rehash();
            } 
        }

        public boolean containkey(K key){//o(1)
            int bi = hashfunction(key);
            int di = searchfunction(key,bi);

            if(di !=  -1){//vlaid
                return true;
            }else{
                return false;
            }

        }

        public V get(K key){//O(1)
            int bi = hashfunction(key);
            int di = searchfunction(key,bi);

            if(di !=  -1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }

        }

        public V remove(K key){
            int bi = hashfunction(key);
            int di = searchfunction(key,bi);

            if(di !=  -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value ;
            }else{
                return null;
            }

        }

        public ArrayList<K> keyset(){
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0 ; i <buckets.length ; i++){
                LinkedList<Node>ll = buckets[i];

                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void main (String args[]){
        HashMap<String ,Integer> hm  = new HashMap<>();
        hm.put("India",100);
        hm.put("china",150);
        hm.put("us",50);
        hm.put("nepal",5);

        ArrayList<String>keys = hm.keyset();
        for (String key : keys) {
            System.out.println(key);
        }
    }
}

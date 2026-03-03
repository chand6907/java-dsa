    // import java.util.*;
    // public class Classroom{
    //     static class Heap{
    //         ArrayList<Integer> arr = new ArrayList<>();
            
    //         public void add(int data){
    //             arr.add(data);
    //             int x = arr.size()-1;
    //             int par= (x-1)/2;
    //             while(arr.get(x)<arr.get(par)){
    //                 int temp = arr.get(x);
    //                 arr.set(x, arr.get(par));
    //                 arr.set(par, temp);
                    
    //                 x = par;
    //                     par = (x-1)/2;
                    
    //             }
    //         }
            
    //     public void printHeap() {
    //         System.out.println(arr);
    //     }
        
    //     public int peek(){
    //         return arr.get(0);
    //     }
    //       public void printpeek() {
    //          System.out.println(peek()) ;
        
    //     }
        
    //     public void heapify(int []arr, int i, int size){
    //         int left = 2*i+1;
    //         int right = 2*i+2;
    //         int minIdx = i;
            
    //         if (left < arr.size() && arr.get(minIdx)>arr.get(left)){
    //             minIdx = left ;
    //         }
            
    //         if (right < arr.size() && arr.get(minIdx)>arr.get(right)){
    //             minIdx = right;
    //         }
            
    //         if(minIdx != i){
    //             int temp = arr.get(i);
    //             arr.set(i, arr.get(minIdx));
    //             arr.set(minIdx , temp);
                
    //             heapify(arr,minIdx, size);
    //         }
            
            
    //     }

    //     public static void heapSort(int arr[]){
    //         int n = arr.length;
    //         for(int i =n/2; i>=0;i--){
    //             heapify (arr,i,n);
    //         }
    //     }
        
        
    
        
    //     public int remove(){
    //         int data = arr.get(0);
            
    //         int temp = arr.get(0);
    //         arr.set(0 , arr.get(arr.size()-1));
    //         arr.set(arr.size()-1 , temp);
            
    //         arr.remove(arr.size()-1);
            
    //         heapify(0);
    //         return data ;
    //     }
             
    //     }
    //     public static void main(String[] args) {
    //     Heap h = new Heap();
    //     h.add(3);
    //     h.add(4);
    //     h.add(1);
    //     h.add(5);
    //     h.add(10);
    //   h.printHeap();      
    // h.printpeek();
    // h.remove();          
    // h.printHeap();
    // }
    // }


    import java.util.*;

public class Classroom {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1;
            int par = (x - 1) / 2;
            while (x > 0 && arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public void printHeap() {
            System.out.println(arr);
        }

        public int peek() {
            return arr.get(0);
        }

        public void printpeek() {
            System.out.println(peek());
        }

        // Used for array-based heap sort
        public static void heapify(int[] arr, int i, int size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < size && arr[left] < arr[minIdx]) {
                minIdx = left;
            }
            if (right < size && arr[right] < arr[minIdx]) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;

                heapify(arr, minIdx, size);
            }
        }

        public static void heapSort(int[] arr) {
            int n = arr.length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, i, n);
            }

            // One by one extract elements
            for (int i = n - 1; i > 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr, 0, i);
            }
        }

        // For internal ArrayList heap
        public void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // Swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Remove last
            arr.remove(arr.size() - 1);

            // Heapify from root
            heapify(0);
            return data;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        h.add(10);
        h.printHeap();
        h.printpeek();
        h.remove();
        h.printHeap();

        // Optional: Try heapSort
        int[] arr = { 3, 4, 1, 5, 10 };
        Heap.heapSort(arr);
        System.out.println("Sorted using heapSort: " + Arrays.toString(arr));
    }
}

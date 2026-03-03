// package array;

// public class subarr {

//     public  static void subarr(int nums[] ){
//        int tp = 0 ; 
//         for (int i = 0 ; i<nums.length ; i++){
//             int start  = i ;
//              for (int j = i ; j < nums.length ; j++){
//                 int end = j;
//                 for (int k = start ; k <= end ; k++){
//                     System.out.println(""+nums[k]);


//                 }
//                 tp++;


//              }
//              System.out.println();
//              System.out.println("tp="+tp);
//         }
//     }
//     public static void main (String args[]){
//         int nums []= { 2 ,4 ,6 ,8 ,10  };
//         subarr(nums);

//         for (int i = 0 ; i<nums.length ; i++){
//            int sum  = sum + nums[i];
//             System.out.println("sum"+sum);
//         }
//     }
// }




// package array;

// public class subarr {

//     public static void subarr(int nums[]) {
//         int tp = 0; // total subarrays
//         int max = Integer.MIN_VALUE; // maximum element
//         int min = Integer.MAX_VALUE; // minimum element

//         for (int i = 0; i < nums.length; i++) {
//             int start = i;

//             for (int j = i; j < nums.length; j++) {
//                 int end = j;
//                 int sum = 0;

//                 System.out.print("Subarray: ");
//                 for (int k = start; k <= end; k++) {
//                     System.out.print(nums[k] + " ");
//                     sum += nums[k];

//                     // update max and min while iterating
//                     if (nums[k] > max) {
//                         max = nums[k];
//                     }
//                     if (nums[k] < min) {
//                         min = nums[k];
//                     }
//                 }

//                 System.out.println("→ Sum = " + sum);
//                 tp++;
//             }

//             System.out.println();
//         }

//         System.out.println("Total subarrays = " + tp);
//         System.out.println("Maximum element = " + max);
//         System.out.println("Minimum element = " + min);
//     }

//     public static void main(String args[]) {
//         int nums[] = {2, 4, 6, 8, 10};
//         subarr(nums);
//     }
// }

package array;

public class subarr {

    public  static void subarr(int nums[]){
       int tp = 0 ; 
       
        int largest   = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0 ; i<nums.length ; i++){
            int start  = i ;
             for (int j = i ; j < nums.length ; j++){
                int end = j;
                
                int sum = 0;
                for (int k = start ; k <= end ; k++){
                    System.out.print(" "+nums[k]);
                    
                    sum +=nums[k];
                    
                    

//    for(int sum : sums) {
//     if(sum > largest) largest = sum;
//     if(sum < smallest) smallest = sum;
// }
  

                }
                // System.out.println("\nSum="+sum);
            System.out.println(" Sum = " + sum);

                // Track smallest and largest sum
                if (sum > largest) largest = sum;
                if (sum < smallest) smallest = sum;
                tp++;


             }
             System.out.println();
             System.out.println("smallest = "+smallest);

        System.out.println("largest ="+largest);
             System.out.println("tp="+tp);
        }
    }
    public static void main (String args[]){
        int nums []= { 2 ,4 ,6 ,8 ,10  };
        subarr(nums);


        }

}
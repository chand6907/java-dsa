package array;

import java.util.*;
//just for sum 
public class kadanes {

    public static int maxSubArray(int[] nums) {

        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currSum = Math.max(nums[i], currSum + nums[i]);

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take array size
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        // Create array
        int[] nums = new int[n];

        // Take array elements
        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Apply Kadane's Algorithm
        int result = maxSubArray(nums);

        // Print result
        System.out.println("Maximum Subarray Sum = " + result);

        sc.close();
    }
}
// return sum with the subbarray
// import java.util.*;

// public class kadanes {

//     public static void maxSubArray(int[] nums) {

//         int currSum = nums[0];
//         int maxSum = nums[0];

//         int start = 0;
//         int end = 0;

//         int tempStart = 0;

//         for (int i = 1; i < nums.length; i++) {

//             // Should we start a new subarray?
//             if (nums[i] > currSum + nums[i]) {
//                 currSum = nums[i];
//                 tempStart = i;
//             } else {
//                 currSum = currSum + nums[i];
//             }

//             // Update maximum
//             if (currSum > maxSum) {
//                 maxSum = currSum;
//                 start = tempStart;
//                 end = i;
//             }
//         }

//         System.out.println("Maximum Sum = " + maxSum);

//         System.out.print("Maximum Subarray = ");

//         for (int i = start; i <= end; i++) {
//             System.out.print(nums[i] + " ");
//         }
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter the size of array: ");
//         int n = sc.nextInt();

//         int[] nums = new int[n];

//         System.out.println("Enter the array elements:");

//         for (int i = 0; i < n; i++) {
//             nums[i] = sc.nextInt();
//         }

//         maxSubArray(nums);

//         sc.close();
//     }
// }
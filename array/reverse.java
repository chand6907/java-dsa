package array;

public class reverse {

    public static void reverse(int nums[]){

        int start  = 0 ;
        int end = nums.length - 1;

        while (start<end){
            //swap
            int temp = nums [start];
            nums [start]= nums [end];
            nums [end]= temp;

            start++;
            end--;
        }
         for(int i=0;i<nums.length;i++){
            System.out.println(" "+nums[i]);

        }
        System.out.println();

    }

    public static void main (String args[]){
        int nums []= { 1 ,2 ,3 ,4 ,5  };

        reverse(nums);
        // for(int i=0;i<nums.length;i++){
        //     System.out.println(" "+nums[i]);

        // }
        // System.out.println();
    }
    
}

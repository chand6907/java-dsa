package array;

public class binarysc {

    public static int binarysc(int nums[], int key ){
        int start  = 0 ;
        int end = nums.length - 1;

        while(start <= end ){
            int mid = (start + end ) / 2;

            if (nums[mid ]== key ){
                return mid ;
            }
             if (nums [mid ]<key ){
                start = mid +1;
             }
             else{
end = mid - 1 ;
             }
        }
        return -1;
    }
    public static void main (String args[]){
        int nums[]= { 5 , 8 , 12 , 16 , 23 , 38 , 56 , 72 , 91};
        int key = 72;

        System.out.println("MID"+binarysc(nums,key));
    }
}

package array;

class linearsc {
    // Linear search method
    public static int linearSearch(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i; // return index if found
            }
        }
        return -1; // return -1 if not found
    }

    // Main method
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 7, 18, 5, 9};
        int key = 1;

        int index = linearSearch(nums, key);

        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + index);
        }
    }
}

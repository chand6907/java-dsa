
package sorting;
public class bubblesort {   
    public static void bubble(int arr[]) {
        int swap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                                    swap++;

                }
            }
             if (swap == 0) {
                System.out.println("Array sorted early at pass " + (i + 1));
                break;
            }
        }

    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 2, 3};
        bubble(arr);
        printarr(arr);
    }
}

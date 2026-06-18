package sorting;

public class quicksort {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void quicksort(int arr[], int si, int ei){

        if(si>=ei){
            return;
        }
        //last element as pivot
        int pidx = partition(arr,si,ei);
        //left
        quicksort(arr,si,pidx-1);
        //right
        quicksort(arr,pidx+1,ei);

    }

    public static int partition(int arr[],int si,int ei){
        int pivot = arr[ei];
        int i = si-1;

        for (int j = si; j<ei;j++){
            if(arr[j]<pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

            }
        }
i++;
        //swap pivot
        int temp = pivot;
        arr[ei]=arr[i];
arr[i]=temp;
return i;
    }

    public static void main (String args[]){
        int arr[]={5,4,1,3,2,6,7};
        quicksort(arr,0,arr.length-1);
        printArray(arr);
    }
}

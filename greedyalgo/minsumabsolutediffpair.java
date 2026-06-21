package greedyalgo;
import java.util.*;
public class minsumabsolutediffpair {
    public static void main(String[] args) {
    int A[] = {1, 3, 5, 7};
    int B[] = {2, 4, 6, 8};

    Arrays.sort(A);
    Arrays.sort(B);

    int minDiff = 0;

    for (int i  = 0 ; i < A.length ; i++){
        minDiff += Math.abs(A[i] - B[i]);
    }
System.out.println(minDiff);
}
}
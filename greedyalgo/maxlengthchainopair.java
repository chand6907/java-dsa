package greedyalgo;

public class maxlengthchainopair {
    public static void main (String args[]){

        int pairs[][]= {{5, 24}, {15, 25}, {27, 40}, {50, 60}};

        int chainLen = 1;
        int chainEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++){
            if (pairs[i][0] > chainEnd){
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println(chainLen);
    }

}

package recursionadv;

public class tilingprblem {
    public static int tilling(int n){
        if (n==0 || n==1){
            return 1;
        }
        //vertical
        int fnm1 = tilling(n-1);
        //horizontal
        int fnm2 = tilling(n-2);

        return fnm1+fnm2;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(tilling(n)); 
    }
}

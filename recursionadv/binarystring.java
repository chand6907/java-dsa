package recursionadv;

public class binarystring {
    public static void pBinaryString(int n  , int lastPlace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        pBinaryString(n-1, 0 , str+"0");
        if(lastPlace ==0){
            pBinaryString(n-1, 1, str+"1");
        }
        
    }
    public static void main (String args[]){
        pBinaryString(3,0,"");

    }
}

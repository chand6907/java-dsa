package string;

public class compare {
        public static void main(String[] args) {
    String s1 = "chand";
    String s2 = "chand";
    String s3 = new String("chand");

    // if (s1 == s2){
    //     System.out.println("same");

    // }
    // else{
    //     System.out.println("not same");
    // }

    // if(s1 == s3){
    //     System.out.println("same");
    // }else{
    //     System.out.println("not same");
    // }

    if (s1.equals(s3)){
        System.out.println("same");
    }else{
        System.out.println("not same");
    }
}
}

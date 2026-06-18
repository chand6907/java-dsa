package stack;
import java.util.Stack;

public class nextgreater {
    public static void main (String args[]){
        int arr [] = {6 ,  8 , 0 , 1 ,3};
        Stack <Integer> s = new Stack<>();
        int nextGreater [] = new int [arr.length];
        for (int i = arr.length-1; i>=0;i--){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;

            }else{
                nextGreater[i] = s.peek();
            }
            s.push(arr[i]);
        }
        for (int i = 0 ; i < nextGreater.length; i++){
            System.out.print(nextGreater [i]+ " ");
        }

    }
}

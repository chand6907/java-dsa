package binarytree;

public class sumofnodes {
    
    static class Node{
        int data ;
        Node left;
        Node right;
        
         Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    }

    public static int sum(Node root){
        if(root==null){
            return 0;
        }

        int leftsum = sum(root.left);
        int rightsum = sum(root.right);
        return leftsum+rightsum+root.data;
    }

    public static void main(String args[]){

        Node root =  new Node(1);
        root.right =  new Node(2);
        root.left = new Node(3);

        System.out.println(sum(root));
    }
}

package binarytree;

public class countofnodes {
    
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

    public static int count(Node root){
        if(root==null){
            return 0;
        }

        int leftcount= count(root.left);
        int rightcount = count(root.right);
        return leftcount+rightcount+1;

    }

    public static void main(String args[]){

        Node root =  new Node(1);
        root.right =  new Node(2);
        root.left = new Node(3);

        System.out.println(count(root));
    }
}

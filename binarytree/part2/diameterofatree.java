package binarytree.part2;
//aproach1 just for understanding
public class diameterofatree {
    
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

    public static int height(Node root){
        if (root == null){
            return 0;
        }

        int lh= height(root.left);
        int rh = height(root.right);

        return Math.max(lh,rh)+1;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftdiameter = diameter(root.left);
        int leftheight = height(root.left);
        int rightdiameter = diameter(root.right);
        int rightheight = height(root.right);

        int selfdiameter = leftheight + rightheight +1;

        return Math.max(selfdiameter , Math.max(leftdiameter , rightdiameter));
    }

    public static void main(String args[]){

        Node root =  new Node(1);
        root.right =  new Node(2);
        root.left = new Node(3);

        System.out.println(height(root));
    }
}

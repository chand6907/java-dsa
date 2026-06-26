package binarysearchtree;
public class mirrorbst {
        static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static Node createmirror(Node root){
    if(root==null){
        return null;
    }

    Node leftmirror = createmirror(root.left);
    Node rightmirror = createmirror(root.right);

    root.left = rightmirror;
    root.right = leftmirror;
    return root;
}

    public static void main (String args[]){
        Node root =  new Node(1);
        root.left =  new Node(2);
        root.right = new Node(3);

         root = createmirror(root);
         preorder(root);

    }
}

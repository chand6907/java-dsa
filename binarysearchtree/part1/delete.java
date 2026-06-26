package binarysearchtree;

public class delete {

        static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root , int val){
        if(root==null){
            root = new Node(val);
            return root;
        }

        if(root.data>val){
            //left
            root.left = insert(root.left, val);

        }else{
            //right
            root.right = insert(root.right , val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static Node delete(Node root , int val){
        if(root.data<val){
            root.right = delete(root.right,val);
        }else if(root.data>val){
            root.left = delete(root.left,val);
        }
        else{//voila
            //case 1-leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            //case2-single child
            if(root.left==null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case3-having 2child

            Node IS = findinordersucessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }
        return root;
    }
    public static Node findinordersucessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

     public static void main (String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

         for (int i =0 ; i <values.length;i++){
         root = insert(root,values[i]);
        }

          inorder(root);
        System.out.println();
    
        root = delete(root,4);
        System.out.println();

        inorder(root);
    }
}

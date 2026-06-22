package binarytree;
public class buildtree {

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


    static class binarytree{
                static int idx = -1;

        public static Node buildtree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node (nodes[idx]);
            newNode.left = buildtree(nodes);
            newNode.right = buildtree(nodes);
            return newNode;

        }
        //preoder
        public static void preorder(Node root){

            if (root == null){
                return;
            }
            System.out.println(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        //inorder
        public static void inorder(Node root){

            if (root == null){
                return;
            }
             inorder(root.left);
            System.out.println(root.data+" ");
            inorder(root.right);
        }
        //postorder
        public static void postorder(Node root){

            if (root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data+" ");

        }

    }

    public static void main(String args[]){
            int nodes[] = { 1 , 2  , 4  , -1 , -1 , 5 , -1 , -1 , 3 , -1 , 6 , -1 , -1 };
            binarytree tree = new binarytree();
            Node root = tree.buildtree(nodes);
            // System.out.println(root.data);
            // tree.preorder(root);
            // tree.inorder(root);
            // tree.postorder(root);

    }
     
}
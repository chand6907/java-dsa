// package binarytree.part2;
// // approach2 the main approach
// public class diameterofatree2 {
    
//         static class Node{
//         int data ;
//         Node left;
//         Node right;
        
//          Node(int data){
//         this.data = data;
//         this.left = null;
//         this.right = null;
//     }
//     }

//     // public static int height(Node root){
//     //     if (root == null){
//     //         return 0;
//     //     }

//     //     int lh= height(root.left);
//     //     int rh = height(root.right);

//     //     return Math.max(lh,rh)+1;
//     // }

//     // public static int diameter(Node root){
//     //     if(root == null){
//     //         return 0;
//     //     }
//     //     int leftdiameter = diameter(root.left);
//     //     int leftheight = height(root.left);
//     //     int rightdiameter = diameter(root.right);
//     //     int rightheight = height(root.right);

//     //     int selfdiameter = leftheight + rightheight +1;

//     //     return Math.max(selfdiameter , Math.max(leftdiameter , rightdiameter));
//     // }

//     static class info{
//         int diameter;
//         int height;

//         public info(int diameter , int height){
//             if(root == null){
//                 return new inf0(0 , 0);
//             }
//             this.diameter = diameter;
//             this.height = height;
//         }
//         public static info diameter(Node root){
//             info leftinfo = diameter(root.left);
//             info rightinfo = diameter(root.right);

//             int diameter = Math.max(Math.max(leftinfo.diameter , rightinfo.diameter , leftinfo.height+ rightinfo.height+1));
//             int height = Math.max(leftinfo.height,rightinfo.height);

//             return new info (diameter , height);
//         }
//     }

//     public static void main(String args[]){

//         Node root =  new Node(1);
//         root.right =  new Node(2);
//         root.left = new Node(3);

//         System.out.println(height(root));
//     }
// }


package binarytree.part2;

public class diameterofatree2 {

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

    // Info class
    static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    // Optimized diameter function
    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int selfDiameter = leftInfo.height + rightInfo.height + 1;

        int finalDiameter = Math.max(selfDiameter,
                Math.max(leftInfo.diameter, rightInfo.diameter));

        return new Info(finalDiameter, height);
    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        Info result = diameter(root);

        System.out.println("Diameter: " + result.diameter);
    }
}

// package binarytree.part2;
// import java.util.*;
// public class topview {
    
//           static class Node {
//         int data;
//         Node left;
//         Node right;

//         Node(int data) {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     static class Info{
//         Node node ;
//         int hd;

//         public Info(Node node , int hd){
//             this.node = node;
//             this.hd=hd;
//         }
//     }
//     public static void topview(Node root){
//         //level order
//         Queue<Info>q = new LinkedList<>();
//         HashMap<Integer , Node> map = new HashMap<>();

//         int min=0, max=0;
//          q.add(new Info  (root,0));
//         //  q.add(null);

//          while(!q.isEmpty()){
//             Info curr = q.remove();
//             if (q.isEmpty()){
//                 break;
//             }else{
//                 q.add(null);
//             }
//          }
//         if(!map.containsKey(curr.hd)){
//             map.put(curr.hd,curr.node);
//         }
//         if(curr.node.left!=null){
//             q.add(new Info(curr.node.left, curr.hd-1));
//             min = Math.min(min,curr.hd-1);
//         }
//         if(curr.node.right!=null){
//             q.add(new Info(curr.node.right,curr.hd+1));
//             max = Math.min(min,curr.hd+1);
//         }
//         for (int i = min; i<max ; i++){
//             System.out.println(map.get(i).data);
//         }
//         System.out.println();
//     }

//     public static void main(String args[]){

//       Node var1 = new Node(1);
//       var1.left = new Node(2);
//       var1.right = new Node(3);
//       var1.left.left = new Node(4);
//       var1.left.right = new Node(5);
//       var1.right.left = new Node(6);
//       var1.right.right = new Node(7);
//     }
// }


package binarytree.part2;
import java.util.*;

public class topview {

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

    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topview(Node root) {

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        q.add(new Info(root, 0));
        // ❌ you added null logic but used it wrongly
        // q.add(null); ❌ REMOVE this

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // ❌ your logic block was outside loop → WRONG
            // everything must be INSIDE loop

            // ❌ typo: curr.htd ❌
            // ✅ FIX:
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }

            // ❌ curr.left ❌ (Info has no left/right)
            // ✅ FIX:
            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }

            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));

                // ❌ you used Math.min ❌
                // ✅ FIX:
                max = Math.max(max, curr.hd + 1);
            }
        }

        // ❌ loop should include max also
        // ❌ you used i < max
        // ✅ FIX:
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }

        System.out.println();
    }

    public static void main(String args[]) {

        Node var1 = new Node(1);
        var1.left = new Node(2);
        var1.right = new Node(3);
        var1.left.left = new Node(4);
        var1.left.right = new Node(5);
        var1.right.left = new Node(6);
        var1.right.right = new Node(7);

        // ❌ you forgot to call function
        // ✅ FIX:
        topview(var1);
    }
}
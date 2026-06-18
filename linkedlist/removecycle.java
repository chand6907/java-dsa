// package linkedlist;

// public class removecycle {

//      public static class Node{
//         int data;
//         Node next;

//         public Node(int data){
//             this.data = data;
//             this.next = null;
//         }
//     }
//       public static  void print(){
//         Node temp = head;
//         while(temp!=null){
//             System.out.print(temp.data+ "->");
//             temp=temp.next;
//         }
//         System.out.println("null");
//     }
//     public static Node head;
//     public static void isCycle(){
//         Node slow = head ;
//         Node fast = head;
//         boolean cycle = false;
//         while(fast != null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//             if(fast == slow){
//                 cycle=true;
//                 break;
//             }

//         }
//         if(cycle == false){
//             return ;
//         }

//         slow = head ;
//         Node prev = null;
//         while(slow !=fast ){
//             prev = fast ;
//             slow= slow.next;
//             fast = fast.next;
//         }
//         prev.next = null;

//     }

//       public static void main(String args[]){
//         head = new Node(1);
//         Node temp = new Node (2);
//         head.next = temp;
//         head.next.next = new Node(3);
//         head.next.next.next =temp;
        
//         System.out.println(iscycle());
//         removecycle();
//                     System.out.println(iscycle());

//     }
// }
package linkedlist;

public class removecycle {

    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    // ⭐ Just checks cycle
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    // ⭐ Removes cycle
    public static void removeCycle(){

        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        // detect cycle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                cycle = true;
                break;
            }
        }

        if(!cycle){
            return;
        }

        // find starting point
        slow = head;
        Node prev = null;

        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle
        prev.next = null;
    }

    public static void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]){

        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);

        // create cycle
        head.next.next.next = temp;

        // before removal
        System.out.println("Is cycle present? " + isCycle());

        removeCycle();

        // after removal
        System.out.println("Is cycle present? " + isCycle());

        print();
    }
}

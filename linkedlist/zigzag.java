package linkedlist;

public class zigzag {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = next;
        }
    }
    public void print(){
     Node temp = head;
    while(temp != null){
        System.out.print(temp.data + "->");
        temp = temp.next;
    }
    System.out.println("null");
   }
    public static Node head;
    public static Node tail;
    public static int size;
    public static int prev;


    public void zigzag(){
        Node slow = head ;
        Node fast = head.next;
        while(fast!=null&& fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        Node mid = slow;

        Node curr = mid.next;
        mid.next=null;
        Node prev= null;
         Node next;
         while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
         }
         Node left = head ;
         Node right = prev;
         Node nextL,nextR;

         while(left !=null && right !=null){
            nextL=left.next;
            left.next = right;
            nextR = right.next;
            right.next =nextL;

            left = nextL;
            right= nextR;
         }
    }
    public static void main (String args[]){
        zigzag ll = new zigzag();
         head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

         ll.print();
    ll.zigzag();
    ll.print();


    }
}

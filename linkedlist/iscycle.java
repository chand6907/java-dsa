package linkedlist;

public class iscycle {
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
        while(temp!=null){
            System.out.print(temp.data+ "->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static Node head;
    public static boolean isCycle(){
        Node slow = head ;
        Node fast = head;

        while (fast != null && fast.next !=null){//flyods cfa
            slow = slow.next ;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }

        }
        return false;


    }

    public static void main(String args[]){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next =null;
        
        System.out.println(isCycle());
    }
}

package linkedlist;

public class mergesort {

      public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

        public static void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node getmid(Node head){
Node slow = head ;
Node fast = head.next;

while(fast != null && fast.next != null){
    slow = slow.next ;
    fast = fast.next.next;
}
return slow;

}

    private Node merge(Node head1,  Node head2 ){
    Node mergedll = new Node (-1);
    Node temp = mergedll;

    while(head1 != null && head2 !=null){
        if(head1.data<head2.data){
            temp.next = head1;
            head1=head1.next;
            temp = temp.next;

            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp =temp.next; 
            }
    }
    while (head1 !=null){
         temp.next = head1;
            head1=head1.next;
            temp = temp.next;

    }

      while (head2 !=null){
         temp.next = head2;
            head2=head2.next;
            temp = temp.next;

    }
        return mergedll.next;
}






    

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid 
        Node mid = getmid(head);

        // left and right ms
        Node rightHead = mid.next;
        mid.next = null;
       Node newleft =  mergeSort(head);
        Node newright = mergeSort(rightHead);

        //merge
        return merge(newleft , newright);
    }

    public static void main(String args[]){
        mergesort ll = new mergesort();
    head = new Node(7);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(6);

    ll.print();
    ll.head = ll.mergeSort(head);
    ll.print();

    }

    
}

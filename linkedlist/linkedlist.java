package linkedlist;

public class linkedlist {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = next;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public static int prev;

    //add first
    public void addfirst(int data){
         //create new node 
        Node newNode = new Node(data);
size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //newNode next = head
        newNode.next = head;

        //head = newNode
        head = newNode;
    }



    //add last
    public void addlast(int data){
        //create a new node 
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //tail next = newNode

        tail.next = newNode;
        //tail = newNode
        tail = newNode;
    }

   public void print(){
     Node temp = head;
    while(temp != null){
        System.out.print(temp.data + "->");
        temp = temp.next;
    }
    System.out.println("null");
   }

   //adding in middle 
   public void add (int idx , int data ){

    if (idx == 0){
        addfirst(data);
        return;
    }
    size++;
    Node  newNode = new Node(data);
    Node temp = head;
    int i = 0;
    
    while (i<idx-1){
        temp = temp.next;
        i++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
   }

   public int removeFirst(){
    if (size==0){
        System.out.println("is  empty");
    }else if ( size ==1){
        int val = head.data;
        head = tail = null;
        size = 0;
        return val;
    }
int val = head.data;
head = head.next;
size--;
return val;

   }

   public int removeLast(){
      if (size==0){
        System.out.println("is  empty");
    }else if ( size ==1){
        int val = head.data;
        head = tail = null;
        size = 0;
        return val;
    }
    Node prev = head;
    for (int i = 0; i < size-2; i++){
        prev=prev.next;

    }
    int val = prev.next.data;
    prev.next = null;
    tail = prev;
    size--;
    return val;
   }
   
   

   public int helper (Node head , int Key){
    if(head == null){
        return -1;

    }

    if(head.data==Key){
        return 0;
    }
    int idx = helper(head.next, Key);
    if(idx == -1){
        return -1;
    }
    return idx+1;
   }


   public int recSearch(int Key){
    return helper(head , Key );
   }



   public void reverse(){
    Node prev = null;
    Node curr =  tail = head;
    Node next;

    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr= next;
    }
    head = prev;
   }

   public void deletenthfromend(int n){
    //calculate size of a ll
    int sz=0;
    Node temp=head;
    while(temp != null){
        temp = temp.next;
        sz++;
    }
    if(n==sz){
        head = head.next;//remove first
        return ;
    }

    //sz-n
    int i = 1;
    int iToFind = sz-n;
    Node prev = head ;
    while(i< iToFind){
        prev = prev.next;
        i++;
    }
    prev.next = prev.next.next;
    return;

   }
//slow-fast approach to find mid
   public Node FindMid(Node head){//helper
    Node slow = head;
    Node fast = head;

    while(fast!= null && fast.next !=null){
        slow = slow.next;
        fast = fast.next;
    }
    return slow;//mid
   }

   public boolean checkPalindrome(){
    if(head==null || head.next !=null){
        return true;
    }
    Node midNode = FindMid(head);

    Node prev = null;
    Node curr = midNode;
    Node next;

    while(curr.next!=null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    Node right = prev;
    Node left = head;

    while(right!=null){
        if(left.data!=right.data){
            return false;
        }
        left = left.next;
        right=right.next;
    }
    return true;
   }
    public static void main(String args[]){
        linkedlist ll = new linkedlist();
        ll.print();
        ll.addfirst(2);
        ll.print();
        ll.addfirst(1);
        ll.print(); 
        ll.addlast(3);
                    ll.print();
        ll.addlast(4);
        ll.print();

        ll.add(2,9);
        ll.print();
        System.out.println(ll.size);
        ll.removeFirst();
        ll.print();
        ll.removeLast();
        ll.print();

        System.out.println(ll.recSearch(3));

        ll.reverse();
        ll.print();
        ll.deletenthfromend(2);
        ll.print();
    }

}

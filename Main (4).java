class Linkedlist<T>{
    Node head;
    
    class Node{
        T data;
        Node next;
        
        Node(T val)
        {
            data=val;
            next=null;
        }
    }
    
    Linkedlist(){
        head=null;
    }
    
    void insertfirst(T val){
        Node newNode = new Node(val);
        if(head==null)
            head=newNode;
        else{
            newNode.next=head;
            head=newNode;
        }
    }
    
    void delete(){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }
    
    void insert(T val){
        Node newNode = new Node(val);
        if(head==null)
            head=newNode;
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    
    void insertpos(int pos, T val){
        if(pos==0){
            insertfirst(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        for(int i=0;i<pos-1;i++){
            temp=temp.next;
            if(temp==null){
                throw new IllegalArgumentException("invalid position");
            }
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    
    void deletepos(int pos){
        if(head==null){
            throw new IndexOutOfBoundsException("deletion on empty list");
        }
        if(pos==0){
            head=head.next;
            return;
        }
        Node temp=head;
        Node pre=null;
        for(int i=0;i<pos;i++){
            pre=temp;
            temp=temp.next;
        }
        pre.next=temp.next;
    }
    
    void search(T val){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==val){
                System.out.println(i);
                return;
            }
            i+=1;
            temp=temp.next;
        }
    }
    
    void reverse(){
        Node pre=null;
        Node current=head;
        Node next=head.next;
        while(current!=null){
            next=current.next;
            current.next=pre;
            pre=current;
            current=next;
        }
        head=pre;
    }
    
    void contains(T val){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==val){
                System.out.println(true);
                return;
            }
            i+=1;
            temp=temp.next;
        }
        System.out.println(false);
    }
    
    void get(int pos){
        Node temp=head;
        for(int i=0;i<pos;i++){
            temp=temp.next;
        }
        System.out.println(temp.data);
    }
    
    void update(int pos, T val){
        Node temp=head;
        for(int i=0;i<pos;i++){
            temp=temp.next;
        }
        temp.data=val;
    }
    
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}

public class Main
{
	public static void main(String[] args) {
		Linkedlist<Integer> l = new Linkedlist<Integer>();
		l.insertfirst(11);
		l.insertfirst(32);
		l.insertfirst(43);
		l.insertfirst(24);
		l.insert(100);
		l.insertpos(0,10);
		l.update(1,20);
		l.deletepos(0);
        l.delete();
		l.display();
		l.contains(32);
		l.get(2);
		l.reverse();
		l.display();
	}
}


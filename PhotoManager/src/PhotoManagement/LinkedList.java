package PhotoManagement;



 class Node<T> {
public T data;
public Node <T> Next;

public Node(T val) {
	data=val ;
	Next=null;
}

}





public class LinkedList<T> {

	private Node<T> head;
	private Node <T> current ;
	
	
	

	public LinkedList(){
		head= current =null;
		
	}
	
	// when to put <> when to not and when tp put T in general
	public  void insert (T val) {
		Node<T> tmp;
		if(empty()) {
			head=new Node<T>(val);
			current=head;
		}
	//adding in between
		else {
			tmp=current.Next;
			current.Next=new Node<T>(val);
			current= current.Next;
			current.Next=tmp;
			
		}
		
	}
	
	
	public void remove() {
		if(current==head) {
			head=head.Next;
		}
		
		else {
		//removing in between;	
			Node<T> tmp=head;
			while(tmp.Next!=current) 
				tmp=tmp.Next;
				
			tmp.Next=current.Next;
			
		}
		// must move current afterward
		if (current.Next == null)  
            current = head;  
        else  
            current = current.Next;
		
		
		
		
	}
	
	
	
	// helping method remove after
	public void display() {
	    if (head == null) {
	        System.out.println("empty list");
	    }
	    Node<T> p = head;
	    while (p != null) {
	        System.out.print(p.data + " ");
	        p = p.Next;
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean empty() {
		return head==null;
		
	}
	
	
	public boolean last () {
		
		return current.Next==null;
	}

	public boolean full() {
		return false;
	}
	
	public void findFirst() {
		current =head;
	}
	
	public void findNext() {
		current= current.Next;
	}
	
	
	public T retrieve () {
		return current.data;
	}
	
	
	public void update( T val) {
		
		current.data=val;
	}
	
	
	
	
	
	

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getCurrent() {
		return current;
	}

	public void setCurrent(Node<T> current) {
		this.current = current;
	}


	
	
	
}

public class LL {
    
	private class Node{
        
		int data;
        
		Node next;
    
	}
    
    
	private Node head;
    
	private Node tail;
    
	private int size;

    
	public void display(){
        
		Node a=this.head;
        
		while(a!=null){
            
			System.out.print(a.data+"-->");
            
			a=a.next;
        
		}
        
		System.out.println("End of List");
    
	}

    

	public int getFirst(){
        
		if(this.size==0){
            
			System.out.println("Empty List");
            
			return -1;
        
		}
        
		return this.head.data;
    
	}

    
	
	public int getLast(){
        
		if(this.size==0){
            
			System.out.println("Empty List");
            
			return -1;
        
		}
        
		return this.tail.data;
    
	}

    
	
	public int getAt(int s){
        
		if(this.size==0){
            
			System.out.println("Empty List");
            
			return -1;
        
		}
        
		Node a=this.head;
        
		int t=0;
        
		while(t<s){
            
			a=a.next;
            
			t++;
        
		}
        
		return a.data;
    
	}

    

	public Node getNodeAt(int s){
        
		if(this.size==0){
            
			System.out.println("Empty List");
            
			return null;
        
		}
        
		int t=0;
        
		Node a=this.head;
        
		while(t<s){
            
		a=a.next;
            
		t++;
        
		}
        
		return a;
    
	}

    

	public void addLast(int s){
        
		Node a=new Node();
        
		a.data=s;
        
		a.next=null;
        
		if(this.size==0){
            
			this.head=a;
            
			this.tail=a;
        
		}
        
		else if(this.size==1){
            
			this.head.next=a;
            
			this.tail=a;
        
		}
        
		else{
            
			this.tail.next=a;
            
			this.tail=a;
        
		}
        
		this.size++;
    
	}

    

	public void addFirst(int s){
        
		Node a=new Node();
        
		a.data=s;
        
		if(this.size==0){
            
		this.head=a;
            
		this.tail=a;
            
		a.next=null;
        
		}
        
		else{
            
			a.next=this.head;
            
			this.head=a;
        
		}
        
		this.size++;
    
		}

    

	public void addAt(int s,int i){
        
		if(i<0||i>this.size){
            
		System.out.println("Invalid Index");
            
		return;
        
		}
        
		Node a=new Node();
        
		a.data=s;
        
		a.next=null;
        
		if(i==0){
            
			this.addFirst(s);
        
		}
        
		if(i==this.size){
            
			this.addLast(s);
        
		}
        
		else{
            
			Node c=getNodeAt(i);
            
			Node b=getNodeAt(i-1);
            
			a.next=c;
            
			b.next=a;
        
		}
        
		this.size++;
    
		}

    

	public int removeFirst(){
        
		if(this.size==0){
            System.out.println("Empty List");
            return -1;
        }
        int s=this.head.data;
        if(this.size==1){
            this.head=null;
            this.tail=null;
        }
        else{
            this.head=this.head.next;
        }
        this.size--;
        return s;
    }

    public int removeLast(){
        if(this.size==0){
            System.out.println("Empty List");
            return -1;
        }
        int s=this.tail.data;
        if(this.size==1){
            this.head=null;
            this.tail=null;
        }
        else{
            Node t=this.getNodeAt(this.size-2);
            t.next=null;
            this.tail=null;
            this.tail=t;
        }
        this.size--;
        return s;
    }

    public int removeAt(int s){
        if(s<0||s>=this.size){
            System.out.println("Invalid Index");
            return -1;
        }
        if(s==0){
            return this.removeFirst();
        }
        if(s==this.size-1){
            return this.removeLast();
        }
        else{
            Node a=getNodeAt(s-1);
            Node b=getNodeAt(s);
            a.next=b.next;
            int t=b.data;
            b=null;
            this.size--;
            return t;
        }
    }

    public void reverseData(){
        if(this.size==0){
            System.out.println("Empty List");
            return;
        }
        int t=0;
        int s=this.size-1;
        // 0 1 2 3 4 5 
        while(t<=s){
            Node a=getNodeAt(t);
            Node b=getNodeAt(s);
            int x=a.data;
            int y=b.data;
            x=x+y;
            y=x-y;
            x=x-y;
            t++;
            s--;
        }
    }

    public int mid(){
        Node s=this.head;
        Node t=this.head;
        while(t.next!=null&&t.next.next!=null){
            s=s.next;
            t=t.next.next;
        }
        return s.data;
    }
    // 0 1 --> 2 3 --> 4 5
    // 1 2 3 4 --> 5 6
    // 3 2 1 3 --> 6 5
    public void kReverse(int k){
        if(this.size==0){
            System.out.println("Empty List");
            return;
        }
        LL s=null; 
        LL t=null;
        while(this.size!=0){
            s=new LL();
            for(int i=0;i<k;i++){
                s.addFirst(this.removeFirst());
            }
            if(t==null){
                t=s;
            }
            else{
                t.tail.next=s.head;
                t.size+=s.size;
                t.tail=s.tail;
            }
            this.head=t.head;
            this.tail=t.tail;
            this.size=t.size;
        }
    }

        // 0 1 2 3 4 5 6 7 8 9 10
        // 9 10 0 1 2 3 4 5 6 7 8            --> 2
        // 7 8 9 10 0 1 2 3 4 5 6            --> 4
        // 5 6 7 8 9 10 0 1 2 3 4            --> 6
        // 3 4 5 6 7 8 9 10 0 1 2            --> 8
        // 0 1 2 3 4 5 6 7 8 9 10            --> 11 (size)
        // 9 10 0 1 2 3 4 5 6 7 8            --> 13 ==> 2
        // 7 8 9 10 0 1 2 3 4 5 6            --> 15 ==> 4

        // 2 3 4 5 6 7 8 9 10 0 1            --> -2
        // 4 5 6 7 8 9 10 0 1 2 3            --> -4
        // 4 5 6 7 8 9 10 0 1 2 3            --> 7
    public void kAppend(int k){
        k=k%this.size;
        if(k<0){
            k=this.size+k;
        }
        if(k==0){
            return;
        }
        // 0 1 2 3 4 5 6 7 8 9 10            (size=11)
        // 9 10 0 1 2 3 4 5 6 7 8            --> 2
        // 7 8 9 10 0 1 2 3 4 5 6            --> 4
        Node x=getNodeAt(this.size-k-1);
        x.next=null;
        this.tail.next=this.head;
        this.tail=x;
        this.head=getNodeAt(this.size-k);
    }

    public void reversePointers(){
        // 0-->1-->2-->3-->4-->5 =====> 5-->4-->3-->2-->1-->0
        Node s=this.head;
        Node t=s.next;
        Node v=null;
        while(t!=null){
            // t=s.next;
            v=t.next;
            t.next=s;
            s=t;
            t=t.next;
        }
        Node a=this.head;
        this.head=this.tail;
        this.tail=a;
        this.tail.next=null;
    }
    public static void main(String[] args){
        LL list = new LL();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addAt(100, 1);
		list.display();
        System.out.println("-------------------------------------");
        System.out.println(list.getLast());
		System.out.println(list.getFirst());
		System.out.println(list.getAt(1));
		System.out.println(list.removeFirst());
		list.display();
        // System.out.println(list.size);
        System.out.println("--------------------------------------");
        System.out.println(list.removeLast());
		list.display();
		list.addLast(200);
		list.addLast(300);
		list.display();
		System.out.println(list.removeAt(3));
		list.display();
        System.out.println("----------------------------------------");
        list.reverseData();
		list.display();

		// list.reversePointers();
		// list.display();
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        list.display();

		list.kReverse(3);
		list.display();
		
		list.kAppend(2);
		list.display();
    }
}
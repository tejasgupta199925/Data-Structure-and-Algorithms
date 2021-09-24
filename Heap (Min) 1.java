import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
	private int[] arr;
	private int size;
	private int cap;
	
	Codechef(int cap){
	    this.cap=cap;
	    this.size=0;
	    this.arr=new int[cap];
	}
	
	private int parent(int s){
	    return (s-1)/2;
	}
	
	private int leftchild(int s){
	    return (2*s)+1;
	}
	
	private int rightchild(int s){
	    return (2*s)+2;
	}
	
	public int add(int s){
        if(this.size==this.cap){
            System.out.println("Heap is full");
            return -1;
        }	   
        this.arr[this.size]=s;
        this.upheapify(this.size);
        this.size++;
        return s;
	}
	
	private void upheapify(int s){
	    int ci=this.arr[s];
	    int pi=this.arr[this.parent(s)];
	    if(ci<pi){
	        this.swap(s,this.parent(s));
	        this.upheapify(this.parent(s));
	    }
	}
	
	private void swap(int s,int t){
	    int x=arr[s];
	    int y=arr[t];
	    int temp=arr[s];
	    arr[s]=arr[t];
	    arr[t]=temp;
	}
	
	public int size(){
	    return this.size;
	}
	
	public int min(){
	    return this.arr[0];
	}
	
	public void display(){
	    for(int i=0;i<this.size;i++){
	        System.out.print(arr[i]+"-->");
	    }
	    System.out.println();
	}
	
	public boolean isEmpty(){
	    return this.size==0;
	}
	
    public int delete(){
        this.swap(0,this.size-1);
        int rv=this.arr[this.size-1];
        this.size-=1;
        this.downheapify(0);
        return rv;
    }
    
    private void downheapify(int s){
        int l=this.leftchild(s);
        int r=this.rightchild(s);
        int min=s;
        if(l<this.size&&this.arr[min]>this.arr[l]){
            min=(2*s)+1;
        }
        if(r<this.size&&this.arr[min]>this.arr[r]){
            min=(2*s)+2;
        }
        if(min!=s){
            this.swap(s,min);
            this.downheapify(min);
        }
    }
    
    /* Maintain a heap of size k. In each iteration, add the new element, if size exceeds k, then 
       delete 1 element. At the end, the required element will be at the root.
       Applicable for both max and min heaps. */
    public int kMax(int k,int[] st){
        if(k>st.length){
            System.out.println("K too large for array");
            return -1;
        }
        Codechef heap=new Codechef(k);
        for(int i:st){
            heap.add(i);
            if(heap.size()>k){
                heap.delete();
            }
            //heap.add(i);
        }
        return heap.min();
    }
	
	public static void main (String[] args) throws java.lang.Exception{
		Codechef c=new Codechef(10);
// 		System.out.println(c.size());
// 		c.add(10);
		c.add(20);
		c.add(30);
		c.add(-1);
		c.add(40);
		c.add(10);
// 		System.out.println(c.size());
// 		System.out.println(c.min());
// 		c.display();
// 		System.out.println(c.delete());
// 		System.out.println(c.min());
// 		c.display();
		int[] arr={10,20,30,5,0,1,2};
		System.out.println(c.kMax(4,arr));
	}
}
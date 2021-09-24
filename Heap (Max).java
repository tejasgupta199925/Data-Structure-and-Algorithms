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
	    this.arr=new int[this.cap];
	}
	
	public int size(){
	    return this.size;
	}
	
	public boolean isEmpty(){
	    return this.size==0;
	}
	
	private int parent(int s){
	    return (s-1)/2;
	}
	
    private int left(int s){    
	    return (2*s)+1;
	}
	
	private int right(int s){
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
	    int par=this.parent(s);
	    if(this.arr[s]>this.arr[par]){
	        this.swap(s,par);
	        this.upheapify(par);
	    }
	}
	
	private void swap(int s,int t){
	    int temp=this.arr[s];
	    this.arr[s]=this.arr[t];
	    this.arr[t]=temp;
	}
	
	public void display(){
	    for(int i=0;i<this.size;i++){
	        System.out.print(this.arr[i]+"-->");
	    }
	    System.out.println();
	}
	
	public int max(){
	    return this.arr[0];
	}
	
	public int delete(){
	    if(this.size==0){
	        System.out.println("Empty Heap");
	        return -1;
	    }
	    this.swap(0,this.size-1);
	    int rv=this.arr[this.size-1];
	    this.size-=1;
	    this.downheapify(0);
	    return rv;
	}
	
	private void downheapify(int s){
	    int l=this.left(s);
	    int r=this.right(s);
	    int max=s;
	    if(l<this.size&&arr[max]<arr[l]){
	        max=l;
	    }
	    if(r<this.size&&arr[max]<arr[r]){
	        max=r;
	    }
	    if(max!=s){
	        this.swap(s,max);
	        this.downheapify(max);
	    }
	}
	
	public int kMin(int k,int[] st){
	    if(k>st.length){
	        System.out.println("K too large for array");
	        return -1;
	    }
	    Codechef heap=new Codechef(k);
	    for(int i=0;i<k;i++){
	        heap.add(st[i]);
	    }
	    for(int i=k;i<st.length;i++){
	        if(st[i]<heap.max()){
	            heap.arr[0]=st[i];
	            heap.downheapify(0);
	        }
	    }
	    return heap.max();
	}
	
	public static void main (String[] args) throws java.lang.Exception{
        Codechef c=new Codechef(10);
        System.out.println(c.size());
        c.add(10);
        c.add(20);
        c.add(30);
        c.add(40);
        c.add(50);
        c.add(0);
        c.add(35);
        System.out.println(c.size());
        c.display();
        System.out.println(c.max());
        c.delete();
        System.out.println(c.size());
        c.display();
        System.out.println(c.max());
        // int[] arr={10,20,30,40,50,60,70};
        // System.out.println(c.kMin(6,arr));
	}
}
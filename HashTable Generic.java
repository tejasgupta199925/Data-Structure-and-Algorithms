import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef<K,V>{
    private class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;
        Node(K key,V value){
            this.key=key;
            this.value=value;
        }
    }
    
    private int DEFAULT_CAPACITY=10;
    private int size;
    private ArrayList<Node<K,V>> bucket;
    
    Codechef(){
        this.size=0;
        bucket=new ArrayList<>();
        for(int i=0;i<this.DEFAULT_CAPACITY;i++){
            bucket.add(null);
        }
    }
    
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return this.size==0;
    }
    
    public int hash(K str){
        int hashcode=str.hashCode();
        hashcode=Math.abs(hashcode);
        return hashcode%this.DEFAULT_CAPACITY;
    }
    
    public void add(K key, V value){
        int hashcode=this.hash(key);
        Node<K,V> head=this.bucket.get(hashcode);
        Node<K,V> ll=new Node<K,V>(key,value);
        if(head==null){
            bucket.set(hashcode,ll);
            this.size++;
        }
        else{
            while(head!=null){
                if(head.key.equals(key)){
                    head.value=value;
                    return;
                }
                head=head.next;
            }
            head=this.bucket.get(hashcode);
            ll.next=head;
            this.bucket.set(hashcode,ll);
            this.size++;
        }
        double load=(this.size*1.0)/this.DEFAULT_CAPACITY;
        if(load>=0.75){
            System.out.println("Rehashing for "+key);
            this.rehash();
        }
    }
    
    public void rehash(){
        ArrayList<Node<K,V>> temp=this.bucket;
        this.bucket=new ArrayList<>();
        this.DEFAULT_CAPACITY*=2;
        this.size=0;
        for(int i=0;i<this.DEFAULT_CAPACITY;i++){
            this.bucket.add(null);
        }
        for(int i=0;i<temp.size();i++){
            Node<K,V> head=temp.get(i);
            if(head==null){
                continue;
            }
            else{
                while(head!=null){
                    this.add(head.key,head.value);
                    head=head.next;
                }
            }
        }
    }
    
    public V get(K key){
        int hashcode=this.hash(key);
        Node<K,V> head=this.bucket.get(hashcode);
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return null;
    }
    
    public V delete(K key){
        int hashcode=this.hash(key);
        Node<K,V> curr=this.bucket.get(hashcode);
        Node<K,V> prev=null;
        while(curr!=null){
            if(curr.key.equals(key)){
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        if(curr==null){
            return null;
        }
        if(prev==null){
            this.bucket.set(hashcode,curr.next);
        }
        else{
            prev.next=curr.next;
        }
        this.size--;
        return curr.value;
    }
    
    public void display(){
        for(int i=0;i<this.bucket.size();i++){
            Node<K,V> head=this.bucket.get(i);
            if(head==null){
                System.out.println("Null");
                continue;
            }
            else{
                while(head!=null){
                    System.out.print("{"+head.key+","+head.value+"} ");
                    head=head.next;
                }
            }
            System.out.println();
        }
    }
    

	public static void main (String[] args) throws java.lang.Exception{
		Codechef<Integer,Character> c=new Codechef<>();
// 		System.out.println(c.size());
// 		System.out.println(c.isEmpty());
        c.add(1,'G');
        c.add(2,'G');
        c.add(3,'G');
        c.add(4,'G');
		c.add(5,'G');
		c.add(6,'A');
		c.add(7,'A');
		c.add(8,'A');
// 		c.add(9,'A');
// 		c.add(12,'A');
// 		c.add(11,'A');
// 		c.add(10,'A');
// 		c.add(100,'A');
		System.out.println(c.size());
// 		c.display();
		System.out.println("------------------------------------");
		Codechef<String,Character> t=new Codechef<>();
// 		System.out.println(t.size());
// 		System.out.println(t.isEmpty());
		t.add("Sonali",'A');
		t.add("SONALI",'G');
		t.add("Tejas",'G');
		t.add("Facebook",'F');
		t.add("Amazon",'A');
		t.add("Apple",'A');
		t.add("Google",'G');
		t.add("American Express",'A');
		t.add("Ameriprise Financial",'F');
		t.add("Amex",'M');
		t.add("Ampf",'P');
		t.add("AWS",'W');
		t.add("Amazon Web Services",'T');
		t.add("Microsoft",'S');
// 		System.out.println(t.get("Tejas"));
// 		System.out.println(t.get("Sonali"));
// 		System.out.println(t.get("Google"));
// 		System.out.println(t.delete("Sonali"));
// 		System.out.println(t.delete("SONALI"));
// 		System.out.println(t.delete("American Express"));
		System.out.println(t.size());
		t.display();
	}
}

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
    private class Node{
        String key;
        int value;
        Node next;
        Node(String key,int value){
            this.key=key;
            this.value=value;
        }
    }
    
    private static int DEFAULT_CAPACITY=10;
    private int size;
    private ArrayList<Node> bucket;
    
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
    
    public int hash(String str){
        int hashcode=str.hashCode();
        hashcode=Math.abs(hashcode);
        return hashcode%this.DEFAULT_CAPACITY;
    }
    
    public void add(String key, int value){
        int hashcode=this.hash(key);
        Node head=this.bucket.get(hashcode);
        Node ll=new Node(key,value);
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
        ArrayList<Node> temp=this.bucket;
        this.bucket=new ArrayList<>();
        this.DEFAULT_CAPACITY*=2;
        this.size=0;
        for(int i=0;i<this.DEFAULT_CAPACITY;i++){
            this.bucket.add(null);
        }
        for(int i=0;i<temp.size();i++){
            Node head=temp.get(i);
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
    
    public int get(String key){
        int hashcode=this.hash(key);
        Node head=this.bucket.get(hashcode);
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return -1;
    }
    
    public int delete(String key){
        int hashcode=this.hash(key);
        Node curr=this.bucket.get(hashcode);
        Node prev=null;
        while(curr!=null){
            if(curr.key.equals(key)){
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        if(curr==null){
            return -1;
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
            Node head=this.bucket.get(i);
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
		Codechef c=new Codechef();
// 		System.out.println(c.size());
// 		System.out.println(c.isEmpty());
		c.add("Sonali",25);
		c.add("Tejas",20);
		c.add("Sam",16);
		c.add("India",20);
		c.add("Son",16);
		c.add("ABCDEF",18);
		c.add("SONALI",20);
		c.add("AMEX",21);
		c.add("AMPF",22);
		c.add("American Express",23);
		c.add("Ameriprise Financial",24);
		c.add("Google",25);
		c.add("Apple",26);
		c.add("Amazon",27);
		c.add("Amazon Web Services",28);
		c.add("AWS",29);
		c.add("Internship",29);
		c.add("Facebook",29);
		c.add("Kolkata",16);
		System.out.println(c.size());
		c.display(); 
        // System.out.println(c.get("Sonali"));
        // System.out.println(c.get("SONALI"));
        // System.out.println(c.get("Tejas"));
        // System.out.println(c.get("Son"));
        // System.out.println(c.get("SON"));
        // System.out.println("---------------------------------");
        // System.out.println(c.delete("Amazon"));
        // System.out.println(c.size());
        // System.out.println(c.get("Amazon"));
        // System.out.println(c.delete("Amazon"));
        // c.add("Kolkata",17);
        // System.out.println(c.get("Kolkata"));
        // System.out.println(c.delete("Son"));
        c.display();
        // c.display();
// 		System.out.println(c.isEmpty());
	}
}

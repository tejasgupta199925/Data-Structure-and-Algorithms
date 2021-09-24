import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
    private HashMap<Integer,Integer> parent=new HashMap<>();
    private HashMap<Integer,Integer> rank=new HashMap<>();
    
    public void makeSet(int[] arr){
        for(int i:arr){
            parent.put(i,i);
            rank.put(i,0);
        }
    }
    
    public void makeSet(int s){
        parent.put(s,s);
        rank.put(s,0);
    }
    
    public int find(int s){
        if(this.parent.get(s)!=s){
            this.parent.put(s,this.find(this.parent.get(s)));
        }
        return this.parent.get(s);
    }
    
    public void union(int s,int t){
        int sr=this.find(s);
        int tr=this.find(t);
        if(sr==tr){
            return;
        }
        if(this.rank.get(sr)<this.rank.get(tr)){
            this.parent.put(sr,tr);
        }
        else if(this.rank.get(sr)>this.rank.get(tr)){
            this.parent.put(tr,sr);
        }
        else{
            this.parent.put(tr,sr);
            this.rank.put(sr,this.rank.get(sr)+1);
        }
        for(int i:this.parent.keySet()){
            this.find(i);
        }
    }
    
    public void display(){
        for(int i:this.parent.keySet()){
            System.out.println(i+"    "+this.parent.get(i)+"    "+this.rank.get(i));
            // System.out.print(this.find(i)+"     ");
        }
        // System.out.println();
    }
    
    public boolean check(int s,int t){
        int sr=this.find(s);
        int tr=this.find(t);
        if(sr==tr){
            return true;
        }
        return false;
    }
    
	public static void main (String[] args) throws java.lang.Exception{
        Codechef c=new Codechef();
        int[] arr={1,2,3,4,5,0};
        c.makeSet(arr);
        // c.display();
        // c.makeSet(10);
        // System.out.println("---------------------------------");
        // c.display();
        c.union(5,2);
        c.display();
        System.out.println("---------------------------------");
        // c.union(1,0);
        c.union(1,5);
        c.display();
        System.out.println("---------------------------------");
        System.out.println(c.find(2));
        System.out.println(c.find(1));
        System.out.println(c.find(5));
        c.union(3,4);
        c.display();
        System.out.println("---------------------------------");
        c.union(3,1);
        System.out.println(c.find(5));
        c.display();
        System.out.println(c.check(0,1));
        System.out.println(c.check(5,1));
        System.out.println(c.check(3,4));
        System.out.println(c.check(0,4));
	}
}
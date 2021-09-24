/*
    https://gist.github.com/norman10636/ec5e8e9ea6af84f9f33f5ea4da9b99da
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
    private List<List<Integer>> st;
    
    Codechef(int n){
        st=new ArrayList<>();
        for(int i=0;i<n;i++){
            st.add(new ArrayList<>());
        }
    }
    
    public void addVertex(){
        st.add(new ArrayList<>());
    }
    
    public void addEdge(int s,int t){
        if(this.st.get(s).contains(t)){
            return;
        }
        this.st.get(s).add(t);
        if(s!=t){
            this.st.get(t).add(s);    
        }
    }
    
    public boolean containsEdge(int s,int t){
        return this.st.get(s).contains(t);
    }
    
    public void display(){
        for(int i=0;i<st.size();i++){
            System.out.println(st.get(i));
        }
    }
    
    public List<Integer> getNbrs(int s){
        // return this.st.get(s);
        List<Integer> t=new ArrayList<>();
        t=this.st.get(s);
        return t;
    }
    
    public int countVertex(){
        return this.st.size();
    }
    
    public int countEdge(){
        int s=0;
        for(int i=0;i<this.st.size();i++){
            s+=this.st.get(i).size();
        }
        return s/2;
    }
    
    public void removeEdge(int s,int t){
        if(containsEdge(s,t)==false){
            return;
        }
        Iterator itr=this.st.get(s).iterator();
        while(itr.hasNext()){
            int x=(int)itr.next();
            if(x==t){
                itr.remove();
            }
        }
        Iterator itr1=this.st.get(t).iterator();
        while(itr1.hasNext()){
            int x=(int)itr1.next();
            if(x==s){
                itr1.remove();
            }
        }
    }
        
	public static void main(String[] args) throws java.lang.Exception{
        Codechef c=new Codechef(5);
        c.addEdge(1,3);
        c.addEdge(0,2);
        c.addEdge(4,2);
        c.addEdge(2,3);
        c.addEdge(2,2);
        c.addEdge(2,1);
        c.addEdge(2,1);
        c.addEdge(3,0);
        c.addEdge(3,3);
        // c.display();
        // c.removeEdge(2,4);
        // System.out.println("---------------------");
        c.addVertex();
        // c.display();
        // System.out.println(c.countEdge());
        // System.out.println(c.countVertex());
        // System.out.println("---------------------");
        c.display();
        // System.out.println(c.getNbrs(2));
        // System.out.println(c.containsEdge(2,3));
        // System.out.println(c.containsEdge(1,4));
        // System.out.println(c.containsEdge(5,2));
        System.out.println(c.countVertex());
        System.out.println(c.countEdge());
        c.removeEdge(5,4);
        c.display();
	}
}
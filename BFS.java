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
    
    public void bfs(int s){
        boolean[] arr=new boolean[this.countVertex()];
        this.bfs1(s,arr);                   // For starting bfs with desired node 
        for(int i=0;i<arr.length;i++){
            if(arr[i]==false){
                this.bfs1(i,arr);
            }
        }
        System.out.println();
    }
    
    private void bfs1(int s,boolean[] arr){
        LinkedList<Integer> queue=new LinkedList<>();
        // boolean[] arr=new boolean[this.countVertex()];
        queue.add(s);
        arr[s]=true;
        while(queue.size()!=0){
            int t=queue.poll();
            System.out.print(t+" ");
            Iterator<Integer> i=this.st.get(t).iterator();
            while(i.hasNext()){
                int x=i.next();
                if(arr[x]==false){
                    queue.add(x);
                    arr[x]=true;
                }
            }
        }
    }
        
	public static void main(String[] args) throws java.lang.Exception{
        Codechef c=new Codechef(20);
        c.addEdge(1,2);
        c.addEdge(3,2);
        c.addEdge(4,3);
        c.addEdge(4,5);
        c.addEdge(4,6);
        c.addEdge(5,6);
        c.addEdge(5,7);
        c.addEdge(5,8);
        c.addEdge(6,8);
        c.addEdge(7,8);
        // c.display();
        c.bfs(3);
        c.addEdge(11,12);
        c.addEdge(13,12);
        c.addEdge(14,13);
        c.addEdge(14,15);
        c.addEdge(14,16);
        c.addEdge(15,16);
        c.addEdge(15,17);
        c.addEdge(15,18);
        c.addEdge(16,18);
        c.addEdge(17,18);
        // c.display();
        c.bfs(13);
        
        // System.out.println("-----------------------------");
        // Codechef d=new Codechef(7);
        // d.addEdge(1,2);
        // d.addEdge(1,3);
        // d.addEdge(2,4);
        // d.addEdge(2,5);
        // d.addEdge(3,5);
        // d.addEdge(4,5);
        // d.addEdge(4,6);
        // d.addEdge(5,6);
        // // d.display();
        // d.bfs(1);
        // System.out.println("-----------------------------");
        // Codechef e=new Codechef(8);
        // e.addEdge(0,1);
        // e.addEdge(0,2);
        // e.addEdge(1,3);
        // e.addEdge(4,7);
        // e.addEdge(4,5);
        // e.addEdge(7,6);
        // e.display();
        // e.bfs(2);
	}
}
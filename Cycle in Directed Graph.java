/*
    https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    https://algorithms.tutorialhorizon.com/graph-detect-cycle-in-a-directed-graph/
    
    Cycle is considered only on moving in 1 direction between nodes.
    Do dfs from each vertex and if any returns true then a cycle is found. If current node is already 
    in recursion stack, then cycle found and if current node is already visited but not present in 
    recurion stack, then cycle is not found for that particular dfs. The same process is repeated for
    all neighbours of current node. The current node is popped from recursion stack at the end of each
    dfs traversal.
    A node will remain marked as visited after being marked once but a node will be removed from 
    recursion stack after it's dfs is done (or all possible paths from that node are explored).
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
        return s;
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
    }
    
    public boolean cycle(){
        boolean[] stack=new boolean[this.countVertex()];
        boolean[] visited=new boolean[this.countVertex()];
        for(int i=0;i<this.countVertex();i++){
            if(dfs(i,visited,stack)==true){
                return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int s,boolean[] visited,boolean[] stack){
        if(stack[s]==true){
            return true;
        }
        if(visited[s]==true){
            return false;
        }
        stack[s]=true;
        visited[s]=true;
        List<Integer> nb=this.st.get(s);
        for(int i:nb){
            if(this.dfs(i,visited,stack)==true){
                return true;
            }
        }
        stack[s]=false;
        return false;
    }
    
	public static void main(String[] args) throws java.lang.Exception{
        Codechef c=new Codechef(5);
        c.addEdge(0,1);
        c.addEdge(1,2);
        c.addEdge(2,3);
        c.addEdge(3,4);
        c.addEdge(0,4);
        // c.addEdge(0,2);
        // c.addEdge(0,4);
        c.display();
        System.out.println(c.cycle());
	}
}
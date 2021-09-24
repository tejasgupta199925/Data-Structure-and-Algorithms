/*
    During both BFS and DFS, for a current node, if a neighbouring node is detected which is already
    visited and it is not the parent of current node, then a cycle is detected otherwise not.
    Back-edge for DFS and cross-edge for BFS.
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
    
    class Node{
        int v;
        int parent;
        Node(int v,int parent){
            this.v=v;
            this.parent=parent;
        }
    }
    
    public boolean bfs(int s){
        boolean[] visited=new boolean[this.countVertex()];
        boolean t=this.bfs(s,visited);
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                t=this.bfs(i,visited);
            }
        }
        return t;
    }
    
    private boolean bfs(int s,boolean[] visited){
        // boolean[] visited=new boolean[this.countVertex()];
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(s,-1));
        visited[s]=true;
        while(q.size()>0){
            Node t=q.poll();
            for(int i:this.st.get(t.v)){
                if(visited[i]==false){
                    visited[i]=true;
                    q.add(new Node(i,t.v));
                }
                // Neighbouring node is not a parent of current node and has been visited already
                else if(i!=t.parent){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int s){
        boolean[] visited=new boolean[this.countVertex()];
        boolean t=this.dfs(s,visited,-1);
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                t=this.dfs(i,visited,-1);
            }
        }
        return t;
    }
    
    private boolean dfs(int s,boolean[] visited,int parent){
        visited[s]=true;
        for(int i:this.st.get(s)){
            if(visited[i]==false){
                if(this.dfs(i,visited,s)==true){
                    return true;
                }
            }
            // Neighbouring node is not a parent of current node and has been visited already
            else if(i!=parent){
                return true;
            }
        }
        return false;
    }
        
	public static void main(String[] args) throws java.lang.Exception{
       Codechef c=new Codechef(7);
       c.addEdge(0,1);
       c.addEdge(2,1);
       c.addEdge(0,3);
       c.addEdge(0,4);
    //   c.addEdge(3,4);
       c.addEdge(5,6);
       System.out.println(c.bfs(6));
       System.out.println(c.dfs(5));
	}
}
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
    
    public void dfs(int s){
        boolean[] visited=new boolean[this.countVertex()];
        this.dfs1(s,visited);
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                this.dfs1(i,visited);
            }
        }
    }
    
    private void dfs1(int s,boolean[] visited){
        visited[s]=true;
        System.out.print(s+" ");
        for(int x:this.st.get(s)){
            if(visited[x]==false){
                this.dfs1(x,visited);
            }
        }
    }
    
    public void dfsIterative(int s){
        boolean[] visited=new boolean[this.countVertex()];
        this.dfs2(s,visited);
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                this.dfs2(i,visited);
            }
        }
    }
    
    private void dfs2(int s,boolean[] visited){
        Stack<Integer> arr=new Stack<>();
        arr.push(s);
        while(arr.size()!=0){
            int x=arr.pop();
            if(visited[x]==false){
                visited[x]=true;
                System.out.print(x+" ");
                List<Integer> list=this.st.get(x);
                for(int i=list.size()-1;i>=0;i--){
                    if(visited[list.get(i)]==false){
                        arr.push(list.get(i));
                    }
                }
            }
        }
    }
    
	public static void main(String[] args) throws java.lang.Exception{
        Codechef c=new Codechef(5);
        c.addEdge(1,0);
        c.addEdge(1,1);
        c.addEdge(2,0);
        c.addEdge(1,2);
        c.addEdge(3,0);
        c.addEdge(1,4);
        c.dfs(0);
        System.out.println();
        c.dfsIterative(0);
        System.out.println();
        Codechef d=new Codechef(12);
        d.addEdge(0,1);
        d.addEdge(0,7);
        d.addEdge(0,9);
        d.addEdge(3,1);
        d.addEdge(8,1);
        d.addEdge(2,4);
        d.addEdge(2,5);
        d.addEdge(2,9);
        d.addEdge(3,6);
        d.addEdge(3,8);
        d.addEdge(6,4);
        d.dfs(5);
        System.out.println();
        d.dfsIterative(5);
        //  5-2-4-6-3-1-0-7-9-8
	}
}
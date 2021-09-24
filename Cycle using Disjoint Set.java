import java.util.*;
import java.lang.*;
import java.io.*;

class Edge{
    int src;
    int dest;
    Edge(int src,int dest){
        this.src=src;
        this.dest=dest;
    }
}

class Graph{
    private List<List<Integer>> list;
    private List<Edge> edge;
    Graph(List<Edge> edge,int n){
        list=new LinkedList<>();
        this.edge=edge;
        for(int i=0;i<n;i++){
            list.add(new LinkedList<>());
        }
        for(Edge e:edge){
            list.get(e.src).add(e.dest);
            // list.get(e.dest).add(e.src);      
            // Only 1 side if using adjacency list instead of edge list for cycle detection
        }
    }
    
    public void display(){
        for(int i=0;i<this.list.size();i++){
            System.out.println(list.get(i));
        }
    }
    
    private Map<Integer,Integer> parent=new HashMap<>();
    private Map<Integer,Integer> rank=new HashMap<>();
    
    private void makeSet(){
        for(int i=0;i<this.list.size();i++){
            parent.put(i,i);
            rank.put(i,0);
        }
    }
    
    private int find(int s){
        if(this.parent.get(s)!=s){
            this.parent.put(s,this.find(this.parent.get(s)));
        }
        return this.parent.get(s);
    }
    
    private void union(int s,int t){
        int sr=this.find(s);
        int tr=this.find(t);
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
    
    public boolean cycle(){
        this.makeSet();
        for(Edge e:this.edge){
            int s=this.find(e.src);
            int t=this.find(e.dest);
            if(s==t){
                return true;
            }
            else{
                this.union(e.src,e.dest);
            }
        }
        return false;
    }
}

class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
		List<Edge> e=Arrays.asList(new Edge(0,1),new Edge(1,2),new Edge(0,2),new Edge(2,3),new Edge(3,4));
		Graph g=new Graph(e,5);
		g.display();
		System.out.println(g.cycle());
	}
}
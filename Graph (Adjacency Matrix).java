import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
    private int[][] g;
    
    Codechef(int edg){
        g=new int[edg][edg];
    }
    
	public void addedge(int s,int t){
	    if(s>=g.length||t>=g.length){
	        System.out.print("Invalid input");
	        return;
	    }
	    this.g[s][t]=1;
	    this.g[t][s]=1;
	}
	
	public void removeEdge(int s,int t){
	    if(s>=g.length||t>=g.length){
	        System.out.println("Invalid Input");
	        return;
	    }
	    this.g[s][t]=0;
	    this.g[t][s]=0;
	}
	
	public int noofVtcs(){
	    return this.g.length;
	}
	
	public void display(){
	    for(int i=0;i<g.length;i++){
	        for(int j=0;j<g[0].length;j++){
	            System.out.print(g[i][j]+" ");
	        }
	        System.out.println();
	    }
	}
	
	public boolean connected(int s,int t){
	    return this.g[s][t]==1;
	}
	
	public static void main (String[] args) throws java.lang.Exception{
        Codechef g=new Codechef(5);
        g.addedge(1,2);
        g.addedge(0,2);
        g.addedge(4,3);
        g.addedge(1,0);
        g.display();
        System.out.println(g.connected(1,0));
        System.out.println(g.connected(3,4));
        System.out.println(g.connected(1,3));
	}
}
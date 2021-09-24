import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
    static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
        
        @Override
        public String toString(){
            String strl="", strr="";
            String str=String.valueOf(this.data);
            if(this.left!=null){
                strl=String.valueOf(this.left.data);
            }
            else{
                strl+="null";
            }
            if(this.right!=null){
                strr=String.valueOf(this.right.data);
            }
            else{
                strr+="null";
            }
            return strl+"-"+str+"-"+strr;
        }
    }
    
    private Node root;
    
    Codechef(Node s){
        this.root=s;
        System.out.println(this.root);
    }
    
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+"    ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+"    ");
    }
    
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+"    ");
        inorder(root.right);
    }
    
    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> s=new LinkedList<>();
        s.add(root);
        while(s.size()!=0){
            Node x=s.peek();
            int t=s.poll().data;
            System.out.print(t+"    ");
            if(x.left!=null){
                s.add(x.left);
            }
            if(x.right!=null){
                s.add(x.right);
            }
        }
    }
    
    public static void linelevelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> s=new LinkedList<>();
        s.add(root);
        while(s.size()!=0){
            int freq=s.size();
            while(freq>0){
                Node temp=s.peek();
                System.out.print(temp.data+"    ");
                s.poll();
                freq--;
                if(temp.left!=null){
                    s.add(temp.left);
                }
                if(temp.right!=null){
                    s.add(temp.right);
                }
            }
            System.out.println();
        }
    }
    
    public static void main (String[] args) throws java.lang.Exception{
	    Node root=new Node(10);
	    
	    Node a1=new Node(20);
	    Node a2=new Node(30);
	    root.left=a1;
	    root.right=a2;
	    
	    Node b1=new Node(40);
	    Node b2=new Node(50);
	    Node b3=new Node(60);
	    Node b4=new Node(70);
	    a1.left=b1;
	    a1.right=b2;
	    a2.left=b3;
	    a2.right=b4;
	    
	    Node c1=new Node(80);
	    Node c2=new Node(90);
	    b1.left=c1;
	    b1.right=c2;
	    
	    Codechef c=new Codechef(root);
	    
	   // c.preorder(root);
	   // System.out.println();
	   // c.postorder(root);
	   // System.out.println();
	   // c.inorder(root);
	   // System.out.println();
	    
	   // c.levelorder(root);
	   
	   c.linelevelorder(root);
	}
}
import java.util.*;
import java.lang.*;
import java.io.*;

/*
                        10
              20                  30
          40      50          60      70
       80    90 
           100 
*/

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
    
    public static void spiralorder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> left=new Stack<>();
        Stack<Node> right=new Stack<>();
        boolean flag=false;
        left.push(root);
        while(left.size()!=0||right.size()!=0){
            if(flag==true){
                while(right.size()!=0){
                    Node s=right.peek();
                    System.out.print(s.data+"   ");
                    right.pop();
                    if(s.right!=null){
                        left.push(s.right);
                    }
                    if(s.left!=null){
                        left.push(s.left);
                    }
                }
                flag=false;
            }
            else{
                while(left.size()!=0){
                    Node s=left.peek();
                    System.out.print(s.data+"   ");
                    left.pop();
                    if(s.left!=null){
                        right.push(s.left);
                    }
                    if(s.right!=null){
                        right.push(s.right);
                    }
                    // flag=true;
                }
                flag=true;
            }
        }
    }
    
    public static void reverselevelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> s=new LinkedList<>();
        Stack<Node> t=new Stack<>();
        s.add(root);
        while(s.size()!=0){
            Node temp=s.peek();
            t.push(temp);
            s.poll();
            if(temp.right!=null){
                s.add(temp.right);
            }
            if(temp.left!=null){
                s.add(temp.left);
            }
        }
        while(t.size()!=0){
            Node temp=t.pop();
            System.out.print(temp.data+"    ");
        }
    }
    
    public static void leftsideview(Node root){
        if(root==null){
            return;
        }
        Queue<Node> s=new LinkedList<>();
        s.add(root);
        while(s.size()!=0){
            int freq=s.size();
            boolean flag=true;
            while(freq>0){
                Node temp=s.peek();
                if(flag==true){
                    System.out.print(temp.data+"    ");
                    flag=false;
                }
                s.poll();
                freq--;
                if(temp.left!=null){
                    s.add(temp.left);
                }
                if(temp.right!=null){
                    s.add(temp.right);
                }
            }
        }
    }
    
    public static void nextnode(Node root,int val){
        if(root==null){
            return;
        }
        Queue<Node> s=new LinkedList<>();
        s.add(root);
        while(s.size()!=0){
            int freq=s.size();
            while(freq>0){
                Node temp=s.peek();
                s.poll();
                if(temp.data==val){
                    if(freq==1){
                        System.out.println("null");
                    }
                    else{
                        Node t=s.peek();
                        System.out.println(t.data);
                    }
                }
                if(temp.left!=null){
                    s.add(temp.left);
                }
                if(temp.right!=null){
                    s.add(temp.right);
                }
                freq--;
            }
        }
    }
    
    public static void cornernodes(Node root){
        if(root==null){
            return;
        }
        Queue<Node> s=new LinkedList<>();
        s.add(root);
        while(s.size()!=0){
            boolean flag=true;
            int freq=s.size();
            while(freq>0){
                Node temp=s.peek();
                if(flag==true&&freq==1){
                    System.out.println(temp.data);
                }
                else{
                    if(flag==true){
                        System.out.print(temp.data+"    ");
                        flag=false;
                    }
                    if(freq==1){
                        System.out.println(temp.data);
                    }
                }
                s.poll();
                if(temp.left!=null){
                    s.add(temp.left);
                }
                if(temp.right!=null){
                    s.add(temp.right);
                }
                freq--;
            }
        }
    }
    
    /*
                1                               1
            2       3                       3       2
        4   5   6    7                  7   6   5   4
               8                         8    
    */
    
    public static void invert_recursive(Node root){
        if(root==null){
            return;
        }
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        invert_recursive(root.left);
        invert_recursive(root.right);
    }
    
    public static void invert_queue(Node root){
        if(root==null){
            return;
        }
        Queue<Node> s=new LinkedList<>();
        s.add(root);
        while(s.size()!=0){
            Node temp=s.peek();
            Node t=temp.left;
            temp.left=temp.right;
            temp.right=t;
            s.poll();
            if(temp.left!=null){
                s.add(temp.left);
            }
            if(temp.right!=null){
                s.add(temp.right);
            }
        }
    }
    
    public static void invert_stack(Node root){
        if(root==null){
            return;
        }
        Stack<Node> s=new Stack<>();
        s.push(root);
        while(s.size()!=0){
            Node temp=s.peek();
            Node t=temp.left;
            temp.left=temp.right;
            temp.right=t;
            s.pop();
            if(temp.left!=null){
                s.push(temp.left);
            }
            if(temp.right!=null){
                s.push(temp.right);
            }
        }
    }
    
    public static List<List<Integer>> level(Node root){
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node> s=new LinkedList<>();
        s.add(root);
        while(s.size()!=0){
            int freq=s.size();
            ArrayList<Integer> mini=new ArrayList<>();
            while(freq>0){
                Node temp=s.poll();
                mini.add(temp.data);
                if(temp.left!=null){
                    s.add(temp.left);
                }
                if(temp.right!=null){
                    s.add(temp.right);
                }
                freq--;
            }
            res.add(mini);
        }
        return res;
    }
    
    public static ArrayList<Node> nodeToRoot(Node root,Node s){
        ArrayList<Node> list=new ArrayList<>();
        boolean t=find(root,s,list);
        return list;
    }
    
    public static boolean find(Node root,Node s,ArrayList<Node> list){
        if(root==null){
            return false;
        }
        if(root.data==s.data){
            list.add(root);
            return true;
        }
        boolean lc=find(root.left,s,list);
        if(lc==true){
            list.add(root);
            return true;
        }
        boolean rc=find(root.right,s,list);
        if(rc==true){
            list.add(root);
            return true;
        }
        return false;
    }
    
    public static void kLevelsDown(Node s,int k){
        if(s==null||k<0){
            return;
        }
        if(k==0){
            System.out.print(s.data+"   ");
        }
        kLevelsDown(s.left,k-1);
        kLevelsDown(s.right,k-1);
    }
    
    public static void kLevelsFar(Node root,Node s,int k){
        ArrayList<Node> list=nodeToRoot(root,s);
        for(int i=0;i<list.size();i++){
            Node blocker=null;
            if(i==0){
                blocker=null;
            }
            else{
                blocker=list.get(i-1);
            }
            kLevelsDown(list.get(i),k-i,blocker);
        }
    }
    
    public static void kLevelsDown(Node s,int k,Node blocker){
        if(s==null||k<0||s==blocker){
            return;
        }
        if(k==0){
            System.out.print(s.data+"   ");
            return;
        }
        kLevelsDown(s.left,k-1,blocker);
        kLevelsDown(s.right,k-1,blocker);
    }
    
    public static boolean isCousin(Node root,Node a,Node b){
        if(root==null){
            return false;
        }
        int x=level(root,a,1);
        int y=level(root,b,1);
        if(x!=y){
            return false;
        }
        Node s=findParent(root,a);
        Node t=findParent(root,b);
        if(s!=t){
            return true;
        }
        return false;
    }
    
    public static int level(Node root,Node s,int lev){
        if(root==null){
            return 0;
        }
        if(root==s){
            return lev;
        }
        int lc=level(root.left,s,lev+1);
        if(lc!=0){
            return lc;
        }
        return level(root.right,s,lev+1);
    }
    
    public static Node findParent(Node root,Node s){
        if(root==null||s==null){
            return null;
        }
        if(root.left==s||root.right==s){
            return root;
        }
        Node lc=findParent(root.left,s);
        if(lc!=null){
            return lc;
        }
        return findParent(root.right,s);
    }
    
    public static Node LCA(Node root,int s,int t){
        if(root==null){
            return null;
        }
        if(root.data==s||root.data==t){
            return root;
        }
        // if(root==null){
        //     return null;
        // }
        Node lc=LCA(root.left,s,t);
        Node rc=LCA(root.right,s,t);
        if(lc!=null&&rc!=null){
            return root;
        }
        if(lc==null){
            return rc;
        }
        return lc;
    }
    
    // ***VERY IMPORTANT O(n)***
    public static int diameter(Node root){
        return diameter1(root)[1];
    }
    
    public static int[] diameter1(Node root){
        /* For height when given node is null, return -1 if counting height in terms of edges and 0 
           if counting in terms of nodes.
        */
        int[] res={-1,-1};
        if(root==null){
            return res;
        }
        int[] lr=diameter1(root.left);
        int[] rr=diameter1(root.right);
        int height=Math.max(lr[0],rr[0])+1;
        res[0]=height;
        int s=lr[0]+rr[0]+2;
        int dtr=Math.max(s,Math.max(lr[1],rr[1]));
        res[1]=dtr;
        return res;
    }
    
    public static int maxAncestorDifference(Node root){
        if(root==null){
            return 0;
        }
        return maxAncDiff(root,root.data,root.data);
    }
    
    public static int maxAncDiff(Node root,int max,int min){
        if(root==null){
            return 0;
        }
        if(root.data<min){
            min=root.data;
        }
        if(root.data>max){
            max=root.data;
        }
        int diff=Math.abs(max-min);
        int lc=maxAncDiff(root.left,max,min);
        int rc=maxAncDiff(root.right,max,min);
        return Math.max(diff,Math.max(lc,rc));
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
	    
	    Node d1=new Node(100);
	    c2.left=d1;
	    
	    Codechef c=new Codechef(root);
	    
	   // c.preorder(root);
	   // System.out.println();
	   // c.postorder(root);
	   // System.out.println();
	   // c.inorder(root);
	   // System.out.println();
	    
	   // c.levelorder(root);
	   
	   c.linelevelorder(root);
	   //c.spiralorder(root);
	   //c.reverselevelorder(root);
	   //c.leftsideview(root);
	   //c.nextnode(root,10);
	   //c.nextnode(root,20);
	   //c.nextnode(root,30);
	   //c.nextnode(root,70);
	   //c.nextnode(root,80);
	   //c.cornernodes(root);
	   //c.invert_recursive(root);
	   //c.invert_queue(root);
	   //c.invert_stack(root);
	   //c.linelevelorder(root);
	   //System.out.println(level(root));
	   //ArrayList<Node> s=nodeToRoot(root,d1);
	   //System.out.println(s);
	   //for(int i=0;i<s.size();i++){
	   //    Node temp=s.get(i);
	   //    System.out.print(temp.data+" ");
	   //}
	   //kLevelsDown(a1,2);
	   //System.out.println();
	   //kLevelsFar(root,b2,3);
	   //System.out.println(isCousin(root,b2,b4));
	   //System.out.println(LCA(root,80,100).data);
	   //System.out.println(diameter(root));
	   System.out.println(maxAncestorDifference(root));
	}
}
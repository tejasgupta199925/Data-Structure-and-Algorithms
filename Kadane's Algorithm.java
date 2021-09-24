import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
        /*
            -2 1 -3 4 -1 2 1 -5 4
        */
        int[] arr={-2,-21,-3,-4,-11,-2,-10,-5,-4};
        int glob=Integer.MIN_VALUE;
        int loc=arr[0];
        for(int i=1;i<arr.length;i++){
            loc=max(arr[i],arr[i]+loc);
            if(loc>glob){
                glob=loc;
            }
        }
        System.out.println(glob);
	}
	public static int max(int a,int b){
	    if(a>b){
	        return a;
	    }
	    return b;
	}
}

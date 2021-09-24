import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
        int[] arr={1,-3,-5,-2,0,4,9,0,3,-8,7,-6};
        /*
            (1,1,1)
            (-3,-3,1)
            (15,-5,15)
            (10,-30,15)
            (0,0,15)
            (4,0,15)
            (36,0,36)
            (0,0,36)
            (3,0,36)
            (0,-24,36)
            (7,-168,36)
            (1008,-42,1008)
        */
        System.out.println(fun1(arr));
	}
	public static int fun1(int[] arr){
	    int locmax=arr[0];
	    int locmin=arr[0];
	    int glob=arr[0];
	    for(int i=1;i<arr.length;i++){
	        if(arr[i]>0){
	            locmax=max(locmax*arr[i],arr[i]);
	            locmin=min(locmin*arr[i],arr[i]);
	        }
	        else{
	            int locmax1=max(locmin*arr[i],arr[i]);
	            locmin=min(locmax*arr[i],arr[i]);
	            locmax=locmax1;
	        }
	        glob=max(glob,locmax);
	    }
	    return glob;
	}
	public static int max(int s,int t){
	    if(s>t){
	        return s;
	    }
	    return t;
	}
	public static int min(int s,int t){
	    if(s<t){
	        return s;
	    }
	    return t;
	}
}
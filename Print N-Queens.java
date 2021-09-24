import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
        int n=4;
        int[][] arr=new int[4][4];
        System.out.println(fun1(arr,0));
	}
	public static boolean fun1(int[][] arr,int row){
	    if(row==arr.length){
	        for(int i=0;i<arr.length;i++){
	            for(int j=0;j<arr.length;j++){
	                if(arr[i][j]==1){
	                    System.out.print("Q ");
	                }
	                else{
	                    System.out.print("_ ");
	                }
	            }
	            System.out.println();
	        }
	        System.out.println();
	        return false;
	    }
	    for(int i=0;i<arr.length;i++){
	        if(isSafe(arr,row,i)){
	            arr[row][i]=1;
	            boolean suc=fun1(arr,row+1);
	            if(suc==true){
	                return true;
	            }
	            arr[row][i]=0;              // Backtrack
	        }
	    }
	    return false;
	}
	public static boolean isSafe(int[][] arr,int row,int col){
	    for(int i=row;i>=0;i--){
	        if(arr[i][col]==1){
	            return false;
	        }
	    }
	    for(int i=row,j=col;i>=0&&j>=0;i--,j--){
	        if(arr[i][j]==1){
	            return false;
	        }
	    }
	    for(int i=row,j=col;i>=0&&j<arr.length;i--,j++){
	        if(arr[i][j]==1){
	            return false;
	        }
	    }
	    return true;
	}
}
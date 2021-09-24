import java.util.*;
import java.io.*;
public class Main {
    int[] arr;
    int a,b;
    Main(int n){
        arr = new int[n];
        a=-1;
        b=n;
    }

    void push1(int s){
        if(a==b-1){
            System.out.println("Stack overflow");
            return;
        }
        else{
            a+=1;
            arr[a]=s;
            System.out.println(s+" inserted successfully");
        }
    }
    void push2(int t){
        if(a==b-1){
            System.out.println("Stack overflow");
            return;
        }
        else{
            b-=1;
            arr[b]=t;
            System.out.println(t+" inserted successfully");
        }
    }
    void pop1(){
        if(a==-1){
            System.out.println("Stack Empty");
            return;
        }
        else{
            arr[a]=0;
            a--;
        }
    }
    void pop2(){
        if(b==a){
            System.out.println("Stack Empty");
            return;
        }
        else{
            arr[b]=0;
            b++;
        }
    }
    void display(){
        System.out.print("Stack 1:- ");
        for(int i=0;i<=a;i++){
            System.out.print(arr[i]+"-->");
        }
        System.out.print("\nStack 2:- ");
        for(int i=arr.length-1;i>=b;i--){
            System.out.print(arr[i]+"-->");
        }
    }

    public static void main(String args[]) {
        Main bar = new Main(10);
        // bar.display();
        // System.out.println("-------------------------------------------------------------------------------");
        bar.push1(1);
        bar.push1(2);
        bar.push1(3);
        bar.push2(10);
        bar.push2(9);
        bar.push2(8);
        // bar.display();

        bar.pop1();
        bar.pop2();
        bar.display();
        bar.push1(3);
        bar.push1(4);
        bar.push1(5);
        bar.push1(6);
        bar.push1(7);
        bar.push1(8);
        bar.display();
        bar.push2(11);
        bar.display();
    }
}
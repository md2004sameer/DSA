package Recursion.tail;

public class fibonaci {
    static int helper(int n , int a , int b){
        if(n == 0) return a;
        if(n == 1) return b;

        return helper(n-1, b, a+b);
    }
     public static void main (String args[]){
        int n = 7;
        int ans = helper(n, 0, 1);
        System.out.println(ans);
    }
    
}

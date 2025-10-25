package Recursion.tail;

public class factorial {
    static int helper(int n){
        if( n<=1) return 1;
        return  n * helper(n-1);
       
    }
     public static void main (String args[]){
        int n = 5;
        int ans = helper(n);
        System.out.println(ans);
    }


    
}

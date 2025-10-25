package Recursion.simple;

public class sumDigit {
    
    // sum of a digit in a number 

    static int  helper(int n){
        if( n == 0) return 0;
        
        return n%10 + helper(n/10);
    }
     public static void main(String args[]){
        int ans = helper(123040);
        System.out.println(ans);
    }
}

package Recursion.simple;

public class factorial {
    static int helper(int n){
        if( n <= 1) return 1;
        return n * helper(n-1);
    }
    
}

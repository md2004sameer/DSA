package Recursion.simple;

public class cntDigit {
    // count digit in a number 

    static int helper(int n ){
        if(n == 0) return 0;

        return 1 +  helper(n/10);
    
    }
     public static void main(String args[]){
        int ans = helper(10123);
        System.out.println(ans);
    }
    
}

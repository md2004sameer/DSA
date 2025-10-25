package Recursion.simple;

public class xPowern {
    static int helper(int x , int n){
        if( n == 0 ) return 1;
      //  System.out.println(n);

        return x * helper(x , n-1);

    }
    public static void main(String args[]){
        int ans = helper(2,3);
        System.out.println(ans);
    }
    
}

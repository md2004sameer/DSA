package Recursion;

public class sum {
    static int  helper(int n ){
        
        // base case 
        if( n <= 1) return 1;
        // recursive calls
        return  n+ helper(n-1);
    }
     public static void main(String args[]){
        int n = 5;
        System.out.println(helper(n));


    }
    
}

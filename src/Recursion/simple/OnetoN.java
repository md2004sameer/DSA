package Recursion.simple;

public class OnetoN {
    static void  helper( int n){
        // base - case 
        if(n ==1 ) {
            System.out.println(n);
            return;
        }
        helper(n-1);
        System.out.println(n);

    }
    public static void main (String args[]){
        int n = 5;
        helper(n);
    }
    
}

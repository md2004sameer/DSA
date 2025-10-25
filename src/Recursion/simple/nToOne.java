package Recursion.simple;

public class nToOne {
    static void helper(int n ){

        // base-case
        if(n == 1 ){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        helper(n-1);
    }
     public static void main (String args[]){
        int n = 5;
        helper(n);
    }
}

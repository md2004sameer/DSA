package Recursion;

public class decToBin {
    static String helper(int n , String st){
        if(n == 0) return st;

        st = n % 2 + st;  // get the remainder one by one as recursion performs.

        return helper(n/2 , st);

    }
     public static void main(String args[]){
        String st = "";
        System.out.println(helper(9, st));


    }
    
}

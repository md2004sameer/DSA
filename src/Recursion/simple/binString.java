package Recursion.simple;

public class binString {
    // it print the all binary number of n - length
    static void helper(int n , String st){
        if(n == 0){
            System.out.println(st);
            return;
        }
        helper(n-1 , st+"0");
        helper(n-1 , st+"1");
    }
    public static void main(String args[]){
        helper(3,"");
    }
}

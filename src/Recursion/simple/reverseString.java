package Recursion.simple;

public class reverseString {
    static String helper(String st){
        if(st.isEmpty()) return st;
        return helper(st.substring(1)) + st.charAt(0);
    }
    public static void main (String args[]){
        String st = "abc";
        System.out.println(helper(st));
    }
}

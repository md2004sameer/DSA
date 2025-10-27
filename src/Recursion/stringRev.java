package Recursion;

public class stringRev {
    static String helper(String st ){
        if(st.isEmpty()) return st;
        return helper(st.substring(1)) + st.charAt(0);

        // sunstring is used to exlude the first char.
        // charAt(0) is used to get the first char
    }
    public static void main(String []args){
        String st = "cba";
        String ans = helper(st);
        System.out.println(ans);
    }
    
}

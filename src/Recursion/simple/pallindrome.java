package Recursion.simple;

public class pallindrome {
    static boolean helper(String st){
        String temp = rev(st);
        return temp.equals(st);

    }
    static String rev(String st){
        if(st.isEmpty()) return st;

        return rev(st.substring(1)) + st.charAt(0); 
    }
    public static void main(String args[]){
        String st = "kayak";
        System.out.println(helper(st));


    }

    
}

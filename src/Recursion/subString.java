package Recursion;

public class subString {

    static void helper(String s , int idx , StringBuilder st){
        if(idx == s.length()){
            System.out.println(st.toString());
            return;
        }
        //include 
        st.append(s.charAt(idx));
        helper(s , idx +1 , st);
        st.deleteCharAt(st.length() -1);

        helper(s , idx+1 , st);
    }
    public static void main(String args[]){
        String s = "abc";
         StringBuilder st = new StringBuilder();
        helper(s, 0, st);
    }
    
}

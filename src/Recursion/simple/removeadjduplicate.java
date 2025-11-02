package Recursion.simple;

public class removeadjduplicate {
    /*
     * the idea is simple , compare the string Builder top element become eqaul to st(String Builder) then delete the top
     * element of st (String Builder) and string first idx and increase it wisely , 
     * once idx reaches the length of s, then return .
     */
    static void  helper(int idx , String s , StringBuilder st){
      
        if(idx == s.length()) return;

        if(st.length() > 0 && st.charAt(st.length() -1) == s.charAt(idx)){
            st.deleteCharAt(st.length() -1 );
        }else{
            st.append(s.charAt(idx));
        }
       helper(idx+1 , s , st);
    }
    public static void main (String args[]){
        StringBuilder st = new StringBuilder();
        helper(0 , "xzaazy" , st);
         System.out.println(st.toString()); // output: "xzay"
    }
}

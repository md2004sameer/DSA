package Recursion;

import java.util.ArrayList;
public class powerSet {
    static void helper(int idx , ArrayList<Integer> curr , int arr[] ){
        if(idx == arr.length){
            System.out.println(curr);
            return;
        }

        curr.add(arr[idx]);
        helper(idx +1 , curr , arr);
        curr.remove(curr.size() -1);

        helper(idx+1 , curr , arr);

    }

    static void helper(int idx , StringBuilder st , String s){
        if(idx == s.length() ){
            System.out.println(st+" ");
            return;
        }
        st.append(s.charAt(idx)+ "");
        helper(idx+1 , st , s);
        st.deleteCharAt(st.length() -1 );

        helper(idx +1 , st , s);
        
    }
    public static void main(String []args){
        String s = "abc";
        int arr [] = {1,2,3};
        StringBuilder st = new StringBuilder();
        helper(0, st, s);
        helper( 0 , new ArrayList<>() , arr);
    }
    
}

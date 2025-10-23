package Backtracking;

import java.util.*;
public class subset {
    public static void helper(int idx ,int []arr , List<Integer> curr){

        if(idx== arr.length){
            System.out.println(curr);
            return;
        }


        // include 
        curr.add(arr[idx]);
        helper(idx+1, arr , curr);
        curr.remove(curr.size()-1);

        helper(idx+1 , arr , curr);
        

    }
     public static void main(String []args){
        int []arr = {1,2,3};
        List<Integer> curr = new ArrayList<>();
        helper(0, arr , curr);
    }
    
}

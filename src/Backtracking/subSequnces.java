package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class subSequnces {

    public static void helper(int idx , List<Integer> curr , int []arr){

        // base case 
        if(idx == arr.length){
            System.out.println(curr);
            return ;
        }

        //include 
        curr.add(arr[idx]);  // choose 
        helper(idx +1 , curr , arr);  // backtrack
        curr.remove(curr.size() -1 );   // unchoose 

        // exclude
        helper(idx+1 , curr , arr);
    }

    public static void main(String []args){
        int []arr = {1,2,3};
        List<Integer> curr = new ArrayList<>();
        helper(0, curr , arr);
    }
    
}

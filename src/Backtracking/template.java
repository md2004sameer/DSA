package Backtracking;

import java.util.List;

public class template {


    /*         --- template ---
    void backtrack(int index, State current) {
    // Base condition: end of input
    if (index == n) {
        process(current);
        return;
    }

    // 1. Choose to include current element
    choose(current, index);
    backtrack(index + 1, current);
    unchoose(current, index); // backtrack step

    // 2. Choose to exclude current element
    backtrack(index + 1, current);
}
    */

    
    public void backtrack(int idx , List<Integer> curr , int[]arr){

        // base case 
        if(idx == arr.length){
            System.out.print(curr +" ");
            return;
        }

        // include 
        curr.add(arr[idx]);  // choose 
        backtrack(idx+1 , curr , arr);
        curr.remove(curr.size() - 1); // unchoose 

        // exclude 
        backtrack(idx+1 , curr , arr);
    }
    
}

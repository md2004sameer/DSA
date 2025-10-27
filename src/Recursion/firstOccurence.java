package Recursion;

public class firstOccurence {
    static int helper(int idx , int arr[] , int target){
        if(idx == arr.length) return -1;
        if(arr[idx] == target) return idx;
        return helper(idx+1 , arr, target);
    }
    
    
    
}

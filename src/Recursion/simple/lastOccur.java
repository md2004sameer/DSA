package Recursion.simple;

public class lastOccur {
    static int helper(int idx , int []arr , int target){ // last occurence
        if(idx == arr.length) return -1;
        int ans = helper(idx+1 ,arr , target);
        if(ans != -1) return ans;
        if(arr[idx] == target) return idx;
        return -1;


    }
    
}

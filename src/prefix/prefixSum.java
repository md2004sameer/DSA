package prefix;

public class prefixSum {
    static void helper(int []arr){
        
        for(int i = 1; i < arr.length;i++){
            arr[i] += arr[i-1];
        }
        
    }
    static void print(int []arr){
        System.out.print("[");
        for(int n : arr){
            System.out.print( n + " ");
        }
        System.out.println("]");

    }
    public static void main(String []  args){
        int []arr = { 1,2,3,4,5};
        print(arr);
        helper(arr);
        print(arr);
    }
}

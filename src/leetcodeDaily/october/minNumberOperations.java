package leetcodeDaily.october;

public class minNumberOperations {
    static int n = 1;
    static int[] helper(int []target){
        int tem [] = new int[target.length];
        

        for(int i = 0; i< tem.length;i++){
            for(int j = 0 ; j< tem.length;j++){
                if(target[j]  >= n) {
                    tem[j] = n;
                }
            }
            n ++;
            
        }
        return tem;
    }
    public static void main(String args[]){
        int [] target ={ 3,1,5,4,2};
        int [] ans = helper(target);
        for(int v : ans){
            System.out.print(v +" ");

        }
       //  System.out.println(n +" ");
        
    }
    // write code to count the no . of changement per iteration .
    
}

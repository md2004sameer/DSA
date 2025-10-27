package Pattern_Problem.using_loops;

public class invertedAT {
    public static void helper(int n){
        for(int i = 0; i<=n;i++){
            for(int j = n; j >= i;j--){
                System.out.print(" * " );
            }
            System.out.println();
        }
    }
     public static void main (String[]args){
        int n = 5;
        helper(n);
    }
    
}

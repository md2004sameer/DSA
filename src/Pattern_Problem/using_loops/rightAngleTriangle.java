package Pattern_Problem.using_loops;

public class rightAngleTriangle {
    static void helper(int n){
        for(int i  = 0 ; i <=n ;i++){ // rows 
            for(int j = 0 ; j <= i ;j++){ //cols
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public static void main (String[]args){
        int n = 5;
        helper(n);
    }
    
}

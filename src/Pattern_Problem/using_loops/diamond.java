package Pattern_Problem.using_loops;

public class diamond {
    public static void helper(int n ){
        for(int i =1 ; i<= n ;i++){

            // for spaces
            for(int j = 1; j <=  n - i;j++){
                System.out.print("   ");
            }

            // for stars
            for(int j = 1; j <= 2 * i - 1;j++){
                System.out.print(" * ");
            }
            System.out.println();  // move to next row
        }
    }

    static void helpers(int n){
        for(int i =n; i >= 1;i--){ // reverse it
            // for space 
            for(int j = 1; j <=n-i;j++){
                System.out.print("   ");
            }
            for(int j =1; j<= 2*i-1; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public static void main (String[]args){
        int n = 5;
        helper(n);
        helpers(n);
    }
    
}

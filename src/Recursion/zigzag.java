package Recursion;

public class zigzag {
    static void print(int n){
        if(n == 0) {
            System.out.print(n+" ");
            return;
        }
        print(n-1);
         System.out.print(n);
        print(n-1);
         System.out.print(n);

    }
    public static void main(String args[]){
        print(4);
    }
    
}

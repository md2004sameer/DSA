package Recursion.simple;

public class fibbonaci {
    static void  helper(int n ){
        System.out.print("0 ");
        int a = 0;
        int b = 1;

        while(n != 0 ){
            int c = a+b;
        System.out.print(c+" ");
        a= b;
        b = c;
        n--;
        }
        
    }
    public static void main(String args[]){
        int n = 10;
       
        helper(n);
    }
}

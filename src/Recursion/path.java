package Recursion;

public class path {
    static void helper(int i , int j , int m , int n , String path ){
        if(i == m-1 && j == n-1){
            System.out.println(path);
            return;
        }
        if(i < m-1) helper(i+1 , j , m , n ,path+" D ");
        if(j < n-1) helper(i , j+1 , m , n , path+" R ");
    }
    static int helper(int i , int j , int m ,int n ){
        if(i == m-1 && j == n-1) return 1;
        int down = 0 ; int right = 0;

        if(i< m-1){
            down = helper(i+1 , j , m , n);
        }
        if(j < n-1){
            right = helper(i , j+1 , m , n);
        }
        return down+ right;
    }

     public static void main(String args[]){
        int m = 3;
        int n = 2;
        helper(0, 0, m , n ,"");
        int ans = helper( 0 , 0 , m , n );
        System.out.println("total path : "+ans);


    }
}

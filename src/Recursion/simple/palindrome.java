package Recursion.simple;

public class palindrome {
    static boolean  helper(int n ){
        int rev = reverse(n, 0);
        System.out.println(rev);
        if(n == rev)  return true;

        return false;

    }
    static int reverse(int n , int rev){
       if(n == 0) return rev;
        return  reverse(n/10 , rev *10 + n%10);
    }
     public static void main(String args[]){
        boolean ans = helper(121);
        System.out.println(ans);
    }
}

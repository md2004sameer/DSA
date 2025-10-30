package leetcodeDaily.october;

public class smallNumSetBit {

    static int helper(int n){
        while(true){
            int bin = getBin(n);
            if(check(bin)) return n;
            n = n+1;
        }
       
    }
    static int getBin(int n ){
        int ans = 0;
        int place = 1;
       
        int rem = 0;
        while(n != 0){
            rem = n % 2;
            n = n/2;
            ans += rem * place;
            place *= 10;
          
        }
        return ans;
    }

    static boolean check(int n ){
       while(n != 0){
        int t = n % 10;
        if(t != 1) return false;
        n = n/10;
       }
       return true;
    }
    public static void main(String args[]){
        int ans = helper(5);

        System.out.println(ans);
    }
    
}

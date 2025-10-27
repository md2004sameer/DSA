package leetcodeDaily.october;

public class hercySaving {
    // leetcode 1716
    // hercy saving problem - mathematics problem 
    /*
     * Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.

Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

Example 1:

Input: n = 4
Output: 10
Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
Example 2:

Input: n = 10
Output: 37
Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.
Example 3:

Input: n = 20
Output: 96
Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
 

Constraints:

1 <= n <= 1000
     */

     /*
      * the idea to solve the problem is iterative , initalize monday_money =1 , and when set loop for 7 days 
      */
   public static int helper(int n) {
        int result= 0;
        int monday_money = 1;
        while(n > 0){
            int days = Math.min(7,n);
            int money = monday_money;
            for(int day = 1 ; day <= days;day++){
                result += money;
                money++;
            }
            n-=7;
            monday_money++;
        }

        return result;
        
    }
    public static void main(String args[]){
        int total_saving= helper(10);
        System.out.println("total saving : "+total_saving);


    }
    
}

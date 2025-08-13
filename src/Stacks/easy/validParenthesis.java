package Stacks.easy;

import java.util.Stack;

public class validParenthesis {

    public static boolean valid(String s){

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            // if it is opening then add to stack 
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }

            // if it is closing 

            if(ch == ')' || ch == ']' || ch == '}') {

             // if stack is empty , return false 
            if(stack.isEmpty()) return false;

            // check closing condn.
            char top = stack.pop();
            if((ch == ')' && top != '(') ||
            (ch == ']' && top != '[') ||
            (ch == '}' && top != '{')) {
            return false;
            }
            }

        }

        return stack.isEmpty();
    }
    public static void main(String args[]){
         String  s  = "({[]}))";
         boolean ans = valid(s);
         System.out.println(s + " is balanced ? : "+ans);

    }
    
}

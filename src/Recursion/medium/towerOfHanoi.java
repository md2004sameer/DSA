package Recursion.medium;

public class towerOfHanoi {
    static void hanoi(int n, char src, char aux, char dest){
    if(n == 1){
        System.out.println(src + " -> " + dest);
        return;
    }
    hanoi(n-1, src, dest, aux); // disk move from src to aux using dest
    System.out.println(src + " -> " + dest);
    hanoi(n-1, aux, src, dest); // disk move from aux to dest using src
}


    public static void main(String args[]){
        hanoi(3 , 'A' , 'B' ,'C');
    }
    
}

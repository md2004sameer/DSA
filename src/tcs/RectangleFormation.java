package tcs;
import java.util.Scanner;
public class RectangleFormation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        int T = sc.nextInt();     
        // Edge case: T = 0
        if (T <= 0) {
            sc.close();
            return;
        }       
        while (T-- > 0) {
            int N = sc.nextInt();
            if (N <= 0) {
                System.out.println(0);
                continue;
            }
            long totalSumOfSquares = 0;
            for (int i = 0; i < N; i++) {
                long val = sc.nextLong();
                totalSumOfSquares += (val * val);
            }
            for (int i = 0; i < N; i++) {
                long val = sc.nextLong();
                totalSumOfSquares += (val * val);
            }
            System.out.println(totalSumOfSquares);
        }
        sc.close();
    }
}
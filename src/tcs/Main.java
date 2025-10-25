package tcs;import java.util.*;
import java.util.function.BiFunction;

public class Main {
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            // Compute overall GCD
            int totalGcd = A[0];
            for (int i = 1; i < n; i++) {
                totalGcd = gcd(totalGcd, A[i]);
            }
            if (totalGcd != 1) {
                System.out.println(0);
                continue;
            }

            // If n==0, skip, but n>=1
            // Build sparse table for GCD
            int k = (int) (Math.log(n) / Math.log(2)) + 1;
            int[][] st = new int[k][n];
            for (int i = 0; i < n; i++) {
                st[0][i] = A[i];
            }
            for (int j = 1; j < k; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    st[j][i] = gcd(st[j-1][i], st[j-1][i + (1 << (j-1))]);
                }
            }

            // Precompute log2 for indices
            int[] log = new int[n+1];
            log[1] = 0;
            for (int i = 2; i <= n; i++) {
                log[i] = log[i/2] + 1;
            }

            // BiFunction for range GCD query
            BiFunction<Integer, Integer, Integer> queryGCD = (l, r) -> {
                int len = r - l + 1;
                int j = log[len];
                return gcd(st[j][l], st[j][r - (1 << j) + 1]);
            };

            // Greedy segmentation
            int segments = 0;
            int i = 0;
            while (i < n) {
                int low = i, high = n-1;
                int candidate = -1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int g = queryGCD.apply(i, mid);
                    if (g == 1) {
                        candidate = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                if (candidate == -1) {
                    break;
                }
                segments++;
                i = candidate + 1;
            }
            System.out.println(segments);
        }
        sc.close();
    }
}
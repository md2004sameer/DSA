package prefix;

public class partition {
    static boolean helper(int arr[]) {
        int n = arr.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        buildPrefix(prefix, arr);
        buildPostfix(postfix, arr);

        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] == postfix[i + 1]) return true;
        }
        return false;
    }

    static void buildPrefix(int[] prefix, int[] arr) {
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        print(prefix);
    }

    static void buildPostfix(int[] postfix, int[] arr) {
        int n = arr.length;
        postfix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] + arr[i];
        }
        print(postfix);
    }
    static void print(int arr[]){
        for(int n : arr){
            System.out.print(n +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean ans = helper(arr);
        System.out.println(ans);
    }
}

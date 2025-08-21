package Sorting;

class Main {

    // Public method to start merge sort
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length]; // Temporary array for merging
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    // Recursive merge sort function
    private static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low >= high) return; // Base case: 1 element is already sorted

        int mid = low + (high - low) / 2;  // Find middle index
        mergeSort(arr, low, mid, temp);     // Sort left half
        mergeSort(arr, mid + 1, high, temp);// Sort right half
        merge(arr, low, mid, high, temp);   // Merge the sorted halves
    }

    // Merge two sorted subarrays: arr[low..mid] and arr[mid+1..high]
    private static void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int i = low, j = mid + 1, k = low;

        // Merge elements into temp in sorted order
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        // Copy remaining elements from left half, if any
        while (i <= mid) temp[k++] = arr[i++];
        // Copy remaining elements from right half, if any
        while (j <= high) temp[k++] = arr[j++];

        // Copy merged elements back to original array
        for (k = low; k <= high; k++) arr[k] = temp[k];
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        mergeSort(arr); // Call merge sort
        for (int n : arr) System.out.print(n + " "); // Print sorted array
    }
}

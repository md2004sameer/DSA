package Sorting;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class selection {
    public static void main(String[] args) {
        int arr[]= { 2,4,6,12,8,65,23,88,56,32,66};
        selectionSort(arr);
        print(arr);
        
    }
    
    // Selection Sort
    public static void selectionSort(int arr[]){
        for(int i = 0; i< arr.length;i++){
            int minIdx = min(arr , i);
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
    
    public static void print(int arr[]){
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
    
    // find min
    public static int min(int arr[] , int start){
        int minIdx = start;
        for(int i = start;i<arr.length;i++){
            if(arr[i] < arr[minIdx]){
                minIdx = i;
            }
        }
        return minIdx;
    }
}
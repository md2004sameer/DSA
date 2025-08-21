package Sorting;

class Main {
    
    
    public static void quickSort(int arr[] , int low , int high){
        if(low < high){
            int mid = partition( arr , low ,  high); 
            // this will return the pivot idx 
            
            quickSort(arr, low , mid -1);
            quickSort(arr, mid +1 , high);
            
        }
        
        
    }
    // helper function to swap elemets
    public static void swap(int arr[] , int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // it place the smaller element on left and larger on right 
    public static int  partition(int arr[] ,int low , int high ){
        int key = arr[high];
        int idx = low -1;
        for(int i = low; i < high;i++){
            if(arr[i] <= key){
                idx++;
                swap(arr, i , idx);
            }
        }
        
        swap(arr, idx+1 , high);
        return idx+1;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,5,4,2};
        quickSort(arr,0, arr.length-1);
        for(int n : arr){
            System.out.print(n +" ");
        }
        
    }
    
    // quick sort 
    /*
    the idea of quick sort is to pick a pivot idx and place the  smaller element on its left and greater element on its right. repeat the same process until it has 0 or 1 element left , and array is sorted now !!
     */
}

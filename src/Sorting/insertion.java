package Sorting;

public class insertion {

    /*
     * Approach  -> is simple consider array into two halves , one is sorted(empty intitailly)  
     *              and another is unsorted , we pick a element from unsorted part and put it in sorted part.
     *              from n to 0 , we the condn satisfy , that in sorted element traversing from n to 0 , 
     *              as soon it become less than curr element , put it element.
     * 
     */
    public static void main(String args[]){
        int arr[] = { 2,4,1,3,5};

        insertionSort(arr);
        for(int i = 0; i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }


    }

    public static void insertionSort(int arr[]){
        for(int i = 0; i<arr.length;i++){
            insert(arr, i);
        }
    }

    public static void insert(int[]arr , int idx){
        int key = arr[idx];  // curr element 
        int j = idx-1;       // start checking curr -1

    while(j>= 0 && arr[j] > key){     // condn for put in sorted array 
        arr[j+1] = arr[j];             // move element , until correct order found       
        j--;                        // move backward
    }
    arr[j+1] = key;      // once hit , put into the place
    }
}

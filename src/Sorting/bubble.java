package Sorting;
class bubble {
    public static void main(String[] args) {
        int arr[] = { 2,4,6,12,8,65,23,88,56,32,66};
        bubbleSort(arr);
        print(arr);
        
    }
     
       public static void bubbleSort(int arr[]){
           for(int i = 0; i< arr.length;i++){
               for(int j =0 ; j< arr.length-i-1;j++){
                   if(arr[j] > arr[j+1]){
                       int temp = arr[j];
                       arr[j] = arr[j+1];
                       arr[j+1] = temp;
                   }
               }
           }
       }
       
       public static void print(int arr[]){
           for(int n : arr){
               System.out.print(n+" ");
           }
       }
}
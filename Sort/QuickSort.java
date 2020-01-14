public class QuickSort {


    public static void QuickSort(int [] arr, int begin, int end){

        if (begin < end) {
            int partitionIndex = partition(arr, begin, end-1);

            QuickSort(arr, begin, partitionIndex-1);
            QuickSort(arr, partitionIndex, end);
        }


    }

    public static int partition(int [] arr, int edge, int pivot){
        for(int i=edge; i< pivot; i++){
            if(arr[i] < arr[pivot]){
                int temp = arr[i];
                arr[i] = arr[edge];
                arr[edge++] = temp;
            }
        }
        if(edge != pivot){
            int temp =  arr[edge];
            arr[edge] = arr[pivot];
            arr[pivot] = temp;
        }
        return edge +1;
    }

}

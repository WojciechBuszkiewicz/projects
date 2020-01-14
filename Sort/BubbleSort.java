public class BubbleSort {


    public static void BubbleSort(int[] arr){
        boolean flag = false;

        while(!flag){
            flag = true;
            for(int i=0; i<arr.length -1 ; i++){
                if(arr[i] > arr[i+1]){
                    int helper = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = helper;
                    flag =false;
                }

            }
        }
    }



}

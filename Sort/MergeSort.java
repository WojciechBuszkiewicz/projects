import java.util.Arrays;

public class MergeSort {


    public static int[] MergerSort(int arr[]){
        int [] leftArr = new int[1];
        int [] rightArr = new int[1];

        if(arr.length > 1){
            leftArr = MergerSort(Arrays.copyOfRange(arr,0,arr.length/2));
            rightArr = MergerSort(Arrays.copyOfRange(arr,arr.length/2,arr.length));
        }else if(arr.length == 1) return arr;

        int[] mergeArr = new int[leftArr.length + rightArr.length];
        int i = 0;
        int j = 0;
        while((i < leftArr.length)  && (j < rightArr.length)){
            if(leftArr[i] <= rightArr[j]){
                mergeArr[i+j] = leftArr[i];
                i++;
            }else {
                mergeArr[i+j] = rightArr[j];
                j++;
            }
        }
        while (i < leftArr.length){
            mergeArr[i+j] = leftArr[i];
            i++;
        }
        while (j < rightArr.length){
            mergeArr[i+j] = rightArr[j];
            j++;
        }


        return mergeArr;

    }

}

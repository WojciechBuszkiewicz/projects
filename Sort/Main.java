import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1,2,-6,424,24,23,1,54,-323,23,12,64,54};
        int[] arr2 = Arrays.copyOf(arr1,arr1.length);
        int[] arr3 = Arrays.copyOf(arr1,arr1.length);
        boolean flag = false;


        System.out.println("Orginal array:");
        for(int element: arr1){
            System.out.print(element + " ");
        }


        BubbleSort.BubbleSort(arr1);

        System.out.println("\n");
        System.out.println("Bubblesort:");
        for(int element: arr1){
            System.out.print(element + " ");
        }

        arr2 = MergeSort.MergerSort(arr2);

        System.out.println("\n");
        System.out.println("Mergesort:");
        for(int element: arr2){
            System.out.print(element + " ");
        }

        QuickSort.QuickSort(arr3,0,arr3.length);

        System.out.println("\n");
        System.out.println("Quicksort:");
        for(int element: arr3){
            System.out.print(element + " ");
        }

    }




}


package Algorithms;

import java.util.Arrays;
import java.util.Random;

public class ArraySort {
    public static void main(String[] args) throws InterruptedException {
        int arrLength = 10;
        int min = 0;
        int max = 1000;
        int position;
        int searchItem = 8;

        int[] arr = new int[arrLength];
        //fillRandomArray(arr, min, max);
        arr = new int[]{8, 4, 5, 7, 5, 5, 1, 7, 7, 6};

        System.out.println(Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------------------------------");
        long timeStart = System.currentTimeMillis();
        //bubbleSort(arr);
        //quickSort(arr);
        //mergeSort(arr,0, arr.length - 1);
        shakerSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Elapsed time: " + (System.currentTimeMillis() - timeStart));
    }

    //ShakerSort --------------------------------------------------------------------------------------------------------
    private static void shakerSort(int[] arr) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }

    //MergeSort --------------------------------------------------------------------------------------------------------
    public static void mergeSort(int[] arr, int begin, int end) {

        if (begin == end) // выход из рекурсии - массив из 1 элемента отсортирован по определению
            return;

        int mid = (begin + end)/2; //

        mergeSort(arr, begin  , mid);    // сортировка 1-й половины массива
        mergeSort(arr,mid + 1, end); // сортировка 2-й половины массива
        merge(arr, begin, end);
    }

    public static void merge(int[] arr, int begin, int end) {
        int mid = (begin + end)/2;
        int[] temp = new int[end - begin + 1];
        int i = begin;
        int j = mid + 1;
        int k = 0;

        while ((i <= mid) || (j <= end)) {
            if (i > mid) {
                temp[k++] = arr[j++];
                continue;
            }
            if (j > end) {
                temp[k++] = arr[i++];
                continue;
            }
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
                continue;
            } else {
                temp[k++] = arr[j++];
                continue;
            }
        }
        for (int ii = 0; ii < end - begin + 1; ii++) {
            arr[begin + ii] = temp[ii];
        }
        //System.out.println(Arrays.toString(t));
    }

    //QuickSort --------------------------------------------------------------------------------------------------------
    private static void quickSort(int[] arr) {
        qs(arr, 0, arr.length-1);
    }
    private static void qs(int arr[], int begin, int end)
    {
        int i, j, k, middle, buffer;

        i = begin; j = end;
        k = (begin+end)/2;
        middle = arr[k];

        do {
            while((arr[i] < middle) && (i < end)) i++;
            while((middle < arr[j]) && (j > begin)) j--;

            if(i <= j) {
                buffer = arr[i];
                arr[i] = arr[j];
                arr[j] = buffer;
                //System.out.println(Arrays.toString(arr) + " i=" + i + "; j=" +j + " middle=" + middle +";");
                i++; j--;
            }
        } while(i <= j);

        if(begin < j) qs(arr, begin, j);
        if(i < end) qs(arr, i, end);
    }

    //BubbleSort -------------------------------------------------------------------------------------------------------
    private static void bubbleSort(int[] arr) {
        int buffer;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                }
            }

        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void fillRandomArray(int[] arr, int min, int max) {
        int randomNum;
        Random rn = new Random();
        for (int i=0; i < arr.length; i++){
            randomNum =  rn.nextInt((max - min) + 1) + min;
            arr[i] = randomNum;
        }
    }
}

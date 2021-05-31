package testTask210529Intellias;

import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        int[] arr2 = {1, 3, 7, 8, 8, 8, 8, 8};
        int[] arr1 = {2, 3, 5, 6, 8, 9};

        int[] finalArr = mergeArrays(arr1, arr2);

        System.out.println(Arrays.toString(finalArr));

    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            int[] buff = arr1;
            arr1 = arr2;
            arr2 = buff;
        }
        int[] res = new int[arr1.length + arr2.length];
        int element = 0;
        for (int i = 0, j = 0; i+j < arr1.length + arr2.length; /*i++, j++*/) {
            
            if ( (i < arr1.length) && (arr1[i] <= arr2[j])) {
                element = arr1[i++];
                
            }  else if (j < arr2.length) {
                element = arr2[j++];
            }
            res[i+j-1] = element;
        }

        return res;
    }
}

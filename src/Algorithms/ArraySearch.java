package Algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class ArraySearch {

    static TreeSet set = new TreeSet();

    public static void main(String[] args) {
        int arrLength = 10;
        int min = 0;
        int max = 10;
        int position;
        int searchItem = 5;

        int[] arr = new int[arrLength];
        fillRandomArray(arr, min, max);
        /*arr = new int[]//{1, 4, 5, 5, 5, 6, 7, 7, 7, 8};
                        //{8, 4, 5, 7, 5, 5, 1, 7, 7, 6};
                {4, 10, 1, 6, 7, 10, 7, 9, 5, 6};*/

        System.out.println(Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------------------------------");
        long timeStart = System.currentTimeMillis();
        //position = linearSearch(arr, searchItem);
        //position = binarySearchIterative(arr, searchItem);
        position = binarySearchRecursive(arr, 0, 9, searchItem);
        System.out.println("Position of element \"" + searchItem + "\" is " + position + ";");

        System.out.println("Elapsed time: " + (System.currentTimeMillis() - timeStart));

        //Определяет все позиции для searchItem
        binarySearchRecursive2(arr, 0, 9, searchItem);
        System.out.println("Position of element \"" + searchItem + "\" is " + set.toString() + ";");

    }

    //BinarySearchRecursive---------------------------------------------------------------------------------------------
    private static int binarySearchRecursive(int[] arr, int firstElement, int lastElement, int elementToSearch) {
        // условие прекращения
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[mid] == elementToSearch)
                return mid;

            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            if (arr[mid] > elementToSearch)
                return binarySearchRecursive(arr, firstElement, mid - 1, elementToSearch);

            // также, вызываем метод рекурсивно по суженным данным
            return binarySearchRecursive(arr, mid + 1, lastElement, elementToSearch);
        }

        return -1;
    }

    private static void binarySearchRecursive2(int[] arr, int firstElement, int lastElement, int elementToSearch) {
        // условие прекращения
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[mid] == elementToSearch)
                set.add(mid);

            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            if (arr[mid] >= elementToSearch)
                binarySearchRecursive2(arr, firstElement, mid - 1, elementToSearch);

            // также, вызываем метод рекурсивно по суженным данным
            binarySearchRecursive2(arr, mid + 1, lastElement, elementToSearch);
        }

        //set.add(-1);
    }

    //BinarySearchIterative---------------------------------------------------------------------------------------------
    private static int binarySearchIterative(int[] arr, int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        int middleIndex;

        // условие прекращения (элемент не представлен)
        while(firstIndex <= lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }

    //LinearSearch------------------------------------------------------------------------------------------------------
    private static int linearSearch(int[] arr, int elementToSearch) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch)
                return index;
        }
        return -1;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void fillRandomArray(int[] arr, int min, int max) {
        int randomNum;
        Random rn = new Random();
        for (int i=0; i < arr.length; i++){
            randomNum =  rn.nextInt((max - min) + 1) + min;
            arr[i] = randomNum;
        }
        Arrays.sort(arr);
    }
}

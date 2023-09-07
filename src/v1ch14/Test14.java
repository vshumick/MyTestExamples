package v1ch14;

import java.util.Arrays;

public class Test14 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // выбираем опорный элемент
            int pivot = arr[(low + high) / 2];
            // разбиваем массив на две части
            int i = low, j = high;
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    // меняем местами элементы
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }
            // рекурсивно сортируем левую и правую части массива
            if (low < j) {
                quickSort(arr, low, j);
            }
            if (high > i) {
                quickSort(arr, i, high);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 60, 35, 2, 45, 320, 5};
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        long startTime = System.nanoTime(); // сохраняем время начала выполнения

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        quickSort(arr, 0, arr.length - 1); // быстрая сортировка

        long endTime = System.nanoTime(); // сохраняем время завершения выполнения

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));

        long duration = (endTime - startTime) / 1000000; // вычисляем время выполнения в миллисекундах
        System.out.println("Время выполнения: " + duration + " миллисекунд");
    }
}


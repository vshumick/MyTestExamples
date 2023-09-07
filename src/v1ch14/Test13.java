package v1ch14;

import java.util.Arrays;

public class Test13 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    // меняем элементы местами
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 60, 35, 2, 45, 320, 5};
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        long startTime = System.nanoTime(); // сохраняем время начала выполнения

        bubbleSort(arr); // сортировка пузырьковым методом

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime(); // сохраняем время завершения выполнения

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));

        long duration = (endTime - startTime) / 1000000; // вычисляем время выполнения в миллисекундах
        System.out.println("Время выполнения: " + duration + " миллисекунд");
    }
}


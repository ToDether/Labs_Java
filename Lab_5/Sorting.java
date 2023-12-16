package Lab_5;

import java.util.Arrays;

public class Sorting {

    // Selection sort
    private static void selectionSortDescending(byte[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            byte temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }

    // Insertion sort
    private static void insertionSortDescending(byte[] array) {
        for (int i = 1; i < array.length; i++) {
            byte key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

        public static void main(String[] args) {
        byte[] byteArray = {5, 2, 9, 1, 5, 6};
        selectionSortDescending(byteArray);
        System.out.println("Selection sort: " + Arrays.toString(byteArray));

        insertionSortDescending(byteArray);
        System.out.println("Insertion sort: " + Arrays.toString(byteArray));
    }
}


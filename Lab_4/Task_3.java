package Lab_4;

import java.util.Arrays;

public class Task_3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        try {
            int[] reversedArray1 = reverseArray(array);
            System.out.println("Result: " + Arrays.toString(reversedArray1));
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong input data:: " + e.getMessage());
        }

        try {
            int[] reversedArray2 = reverseArray(null);
            System.out.println("Result" + reversedArray2);
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong input data:: " + e.getMessage());
        }
    }

    private static int[] reverseArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array can't be empty or null");
        }

        int[] reversedArray = new int[array.length];

        int index = array.length - 1;
        for (int value : array) {
            reversedArray[index--] = value;
        }

        return reversedArray;
    }
}

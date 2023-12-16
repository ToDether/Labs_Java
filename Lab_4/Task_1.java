package Lab_4;

public class Task_1 {

    private static double calculateGeometricMean(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array can't be empty or null");
        }

        double product = 1.0;

        for (int number : array) {
            if (number > 0) {
                product *= number;
            }
        }

        return Math.pow(product, 1.0 / array.length);
    }
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10};

        double geometricMean1 = calculateGeometricMean(array);
        System.out.println("Result " + geometricMean1);

        try {
            double geometricMean2 = calculateGeometricMean(null);
            System.out.println("Result " + geometricMean2);
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong input data: " + e.getMessage());
        }
    }
}
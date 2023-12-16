package Lab_4;

public class Task_2 {
    public static void main(String[] args) {
        // int[] array = {-2, -5, 4, 8, -10, -15};
        int [] array = {1, -2, 3, -4, 5, -6, 7, -8, 9};

        int productOfNegatives1 = calculateProductOfNegatives(array);
        System.out.println("Result: " + productOfNegatives1);
   
        try {
            int productOfNegatives2 = calculateProductOfNegatives(null);
            System.out.println("Result: " + productOfNegatives2);
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong input data: " + e.getMessage());
        }
    }

    private static int calculateProductOfNegatives(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array can't be empty or null");
        }

        int product = 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 && i % 5 == 0) {
                product *= array[i];
            }
        }

        return product;
    }
}
    

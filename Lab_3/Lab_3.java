package Lab_3;

public class Lab_3 {

    public static double task1(double m, double k) {
        double sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(m * 1 / i) * Math.sin(m * i);
        }
        return sum;
    }


    static void printResults_task1(double m, double k) {
        System.out.println("m: " + m + " k: " + k);
        try {
        System.out.println("result: " + task1(m, k));
        } catch (IllegalArgumentException e) {
        System.out.println("EXCEPTION " +  e.getMessage());
        }
    
    }

    // TASK #2
    public static double task2(double t, int n) {
        int i = 1;
        if (t < 0) {
            return sum(i * Math.pow(t, 2), 1, n);
        } else {
            return sum(Math.sqrt(t * i), 1, n);
        }
    }

    private static double sum(double expression, int start, int end) {
        double sum = 0;
        for (int i = start; i <= end; i++) {
            sum += expression;
        }
        return sum;
    }

    static void printResults_task2(double t, int n) {
        System.out.println("t: " + t + " n: " + n);
        try {
        System.out.println("result: " + task2(t, n));
        } catch (IllegalArgumentException e) {
        System.out.println("EXCEPTION " +  e.getMessage());
        }
    
    }

    // TASK#3 
    public static double task3(double epsilon) {
        double sum = 0;
        double i = 1;
    
        while (true) {
            double term = 1 / (i * (i + 1));
            if (Math.abs(term) <= epsilon) {
                if (i > 1) {
                    return sum;
                } else {
                    i++;
                }
            }
    
            sum += term;
            i++;
        }
    }

        public static void main(String[] args) {

        System.out.println("~~~~~~ TASK #1 ~~~~~~~~~");
        printResults_task1(1, 30);
        System.out.println();
        printResults_task1(2, 15);
        System.out.println();
        printResults_task1(5, 10);
        System.out.println();
        System.out.println("~~~~~~ TASK #2 ~~~~~~~~~");
        printResults_task2(1, 2);
        System.out.println();
        printResults_task2(-1.2, 23);
        System.out.println();
        printResults_task2(0, 3);
        System.out.println();
        System.out.println("~~~~~~ TASK #3 ~~~~~~~~~");
        double epsilon = 0.000001;
        double res = task3(epsilon); 
        System.out.println("result: " + res);
    }
}

public class Calculator {
    public static int add(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }
}

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.print("addition: ");
        String operation = System.console().readLine();
        String[] input = operation.split("\\+");
        int[] numbers = new int[input.length];


        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i].strip());
        }

        try {
            System.out.println(Calculator.add(numbers));
        } catch (NumberFormatException e) {
            System.out.println("The given input cannot be converted to an integer.");
        }
    }
}
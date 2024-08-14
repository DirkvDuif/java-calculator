package calculator;

public class Calculator {
    public static float add(float a, float b) {
        return a + b;
    }

    public static float subtract(float a, float b) {
        return a - b;
    }

    public static float multiply(float a, float b) {
        return a * b;
    }

    public static float divide(float a, float b) {
        return a / b;
    }

    public static int getPriority(char operation) {
        switch (operation) {
            case '+', '-' -> {
                return 1;
            }
            case '/', '*' -> {
                return 2;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int getPriority(String operation) {
        switch (operation) {
            case "+", "-" -> {
                return 1;
            }
            case "/", "*" -> {
                return 2;
            }
            case "(" -> {
                return 4;
            }
            default -> {
                return 0;
            }
        }
    }
}

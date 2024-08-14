import calculator.Calculator;
import parser.Parser;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.print("To calculate: ");
        String operation = System.console().readLine();
        calculate(operation);
    }

    protected static void calculate(String instruction) {

        Stack<Float> stack = new Stack<>();

        String rpn = Parser.createReversePolishNotation(instruction.replaceAll(" ", ""));

        String[] tokens = rpn.split(" ");

        for (String token : tokens) {
            if (isOperand(token)) {
                float num2 = stack.pop();
                float num1 = stack.pop();
                float result = calculate(getOperation(token), num1, num2);

                stack.push(result);
            } else {
                stack.push(Float.parseFloat(token));
            }
        }

        System.out.println("answer: " + stack.pop());

    }

    protected static boolean isOperand(String token) {
        return "*-/+".contains(token);
    }

    protected static float calculate(Operation operation, float num1, float num2) {
        switch (operation) {
            case ADD -> {
                return Calculator.add(num1, num2);
            }
            case DIVIDE -> {
                return Calculator.divide(num1, num2);
            }
            case SUBTRACT -> {
                return Calculator.subtract(num1, num2);
            }
            case MULTIPLY -> {
                return Calculator.multiply(num1, num2);
            }

            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    public static Operation getOperation(String operation) throws IllegalArgumentException {
        return switch (operation) {
            case "+" -> Operation.ADD;
            case "-" -> Operation.SUBTRACT;
            case "*" -> Operation.MULTIPLY;
            case "/" -> Operation.DIVIDE;
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }

    public enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}

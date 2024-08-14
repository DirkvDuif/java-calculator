package parser;

import calculator.Calculator;

import java.util.Stack;

public class Parser {
    public static String createReversePolishNotation(String instruction) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < instruction.length(); i++) {
            char c = instruction.charAt(i);

            if (c == '-' && (i == 0 || instruction.charAt(i - 1) == '(' || "+-/*".indexOf(instruction.charAt(i - 1)) != -1)) {
                builder.append(c);
            } else if (Character.isDigit(c) || c == '.') {
                builder.append(c);
            } else {

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        builder.append(" ").append(stack.pop());
                    }
                    stack.pop();
                } else {
                    builder.append(" ");

                    // Pop operators from stack if they have higher or equal precedence
                    while (!stack.isEmpty() && Calculator.getPriority(stack.peek()) >= Calculator.getPriority(c)) {
                        builder.append(stack.pop()).append(" ");
                    }

                    stack.push(c);
                }
            }
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            builder.append(" ");
            builder.append(stack.get(i));
        }

        return builder.toString();
    }
}

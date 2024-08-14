package parser;

import calculator.Calculator;

import java.util.Stack;

public class Parser {
    public static String createReversePolishNotation(String instruction) {
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();

        boolean cleaningStack;

        for (char elementOfInstruction : instruction.replace(" ", "").toCharArray()) {
            if (elementOfInstruction.matches("[+-]?[0-9]+(\\.[0-9]+)?")) {
                builder.append(elementOfInstruction);
                continue;
            }

            builder.append(" ");
            if (elementOfInstruction.equals(")")) {
                cleaningStack = true;
                while (cleaningStack) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        cleaningStack = false;
                        continue;
                    }
                    builder.append(stack.pop());
                }
                continue;
            }

            if (stack.isEmpty()) {
                stack.add(elementOfInstruction);
                continue;
            }

            if (Calculator.getPriority(stack.peek()) < Calculator.getPriority(elementOfInstruction)) {
                stack.add(elementOfInstruction);
            } else {
                builder.append(stack.pop());
                stack.add(elementOfInstruction);
                builder.append(" ");
            }


        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            builder.append(" ");
            builder.append(stack.get(i));
        }

        return builder.toString();
    }
}

package com.dovertraining.assignment4;

public final class BracketValidator {
    private BracketValidator() {
    }

    public static boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>(Math.max(1, expression.length()));

        for (char character : expression.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (stack.isEmpty() || !matches(stack.pop(), character)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean matches(char opening, char closing) {
        return opening == '(' && closing == ')'
                || opening == '[' && closing == ']'
                || opening == '{' && closing == '}';
    }
}

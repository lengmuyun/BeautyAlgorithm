package com.beauty.algorithm.stack;

public class BracketMatcher {

    private Stack<Character> leftBrackets;

    public BracketMatcher() {
        leftBrackets = new ArrayStack<>(10);
    }

    public boolean match(String expression) {
        for (int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if (isLeftBracket(c)) {
                leftBrackets.push(c);
            } else if (isRightBracket(c)) {
                Character left = leftBrackets.pop();
                if (left == null) return false;
                if (!isMatch(left, c)) return false;
            }
        }
        return leftBrackets.isEmpty();
    }

    private boolean isMatch(Character left, Character right) {
        return (left == '{' && right == '}') ||
                (left == '[' && right == ']') ||
                (left == '(' && right == ')');
    }

    private boolean isRightBracket(char c) {
        return c == '}' || c == ']' || c == ')';
    }

    private boolean isLeftBracket(char c) {
        return c == '{' || c == '[' || c == '(';
    }

}

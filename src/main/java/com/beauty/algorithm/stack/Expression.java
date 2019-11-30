package com.beauty.algorithm.stack;

/**
 * 支持表达式计算
 * 运算符+,-,*,/
 * 操作数1~9(支持个位数的+,-,*,/四则运算)
 */
public class Expression {

    /** 操作数栈 */
    private Stack<Integer> numberStack;

    /** 操作符栈 */
    private Stack<Character> operatorStack;

    private static final char[] numbers = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    private static final char[] operators = {
            '+', '-', '*', '/'
    };

    public Expression() {
        numberStack = new ArrayStack<>(10);
        operatorStack = new ArrayStack<>(10);
    }

    public int calculate(String expression) {
        for (int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if (isNumber(c)) {
                numberStack.push(c - '0');
            } else if (isOperator(c)) {
                calculateValueAndPush(c);
            }
        }

        if (operatorStack.isEmpty()) {
            return numberStack.pop();
        }

        while (!operatorStack.isEmpty()) {
            int temp = calculate(numberStack.pop(), numberStack.pop(), operatorStack.pop());
            numberStack.push(temp);
        }
        return numberStack.pop();
    }

    private void calculateValueAndPush(char c) {
        Character operator = operatorStack.peak();
        if (operator == null || isPriorityHighOf(c, operator)) {
            operatorStack.push(c);
        } else {
            int value = calculate(numberStack.pop(), numberStack.pop(), operator);
            operatorStack.pop();
            numberStack.push(value);
            calculateValueAndPush(c);
        }
    }

    /**
     * 判断优先级，参数一的优先级比参数二要高
     * @param c
     * @param operator
     * @return
     */
    private boolean isPriorityHighOf(char c, Character operator) {
        return (c == '*' || c == '/') && (operator == '+' || operator == '-');
    }

    public int calculate(Integer a2, Integer a1, Character operator) {
        switch (operator) {
            case '+':
                return a1 + a2;
            case '-':
                return a1 - a2;
            case '*':
                return a1 * a2;
            case '/':
                return a1 / a2;
            default:
                throw new RuntimeException("unsupported operator: " + operator);
        }
    }

    private boolean isOperator(char c) {
        return isContains(operators, c);
    }

    private boolean isNumber(char c) {
        return isContains(numbers, c);
    }

    private boolean isContains(char[] operators, char c) {
        for (char operator : operators) {
            if (operator == c) return true;
        }
        return false;
    }

}

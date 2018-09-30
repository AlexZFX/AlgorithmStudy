package com.alexzfx.leetCode.stack;

import java.util.LinkedList;

/**
 * Author : Alex
 * Date : 2018/9/30 17:45
 * Description : 150. 逆波兰表达式求值
 */
public class EvalRPN {

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        System.out.println(evalRPN.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(Integer.parseInt(tokens[0]));
        int i = 1, a, b;
        while (i != tokens.length) {
            if (tokens[i].length() == 1 && isOperation(tokens[i].charAt(0))) {
                b = stack.pop();
                a = stack.pop();
                switch (tokens[i].charAt(0)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            ++i;
        }
        return stack.pop();
    }

    private boolean isOperation(char c) {
        return "+-*/".indexOf(c) > -1;
    }
}

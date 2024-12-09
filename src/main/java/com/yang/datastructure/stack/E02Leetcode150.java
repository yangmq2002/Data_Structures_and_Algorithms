package com.yang.datastructure.stack;

import java.util.LinkedList;

public class E02Leetcode150 {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+":
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    Integer d = stack.pop();
                    Integer c = stack.pop();
                    stack.push(c - d);
                    break;
                case "*":
                    Integer f = stack.pop();
                    Integer e = stack.pop();
                    stack.push(e * f);
                    break;
                case "/":
                    Integer h = stack.pop();
                    Integer g = stack.pop();
                    stack.push(g / h);
                    break;
                default:
                    stack.push(Integer.parseInt(t));
                    break;

            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new E02Leetcode150().evalRPN(tokens));
        tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(new E02Leetcode150().evalRPN(tokens));
    }
}

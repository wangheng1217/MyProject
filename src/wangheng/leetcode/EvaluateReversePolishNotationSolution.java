package wangheng.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotationSolution {
    
    public static void main(String[] args) {
        EvaluateReversePolishNotationSolution solution = new EvaluateReversePolishNotationSolution();
        System.out.println(solution.evalRPN(new String[]{"4","-2","/","2","-3","-","-"}));
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        Set<String> opSet = new HashSet<String>();
        opSet.add("+");
        opSet.add("-");
        opSet.add("*");
        opSet.add("/");
        for (String s : tokens) {
            if (opSet.contains(s)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int num = 0;
                switch(s.charAt(0)) {
                    case '+':
                        num = num1 + num2;
                        break;
                    case '-':
                        num = num1 - num2;
                        break;
                    case '*':
                        num = num1 * num2;
                        break;
                    case '/':
                        num = num1 / num2;
                        break;
                }
                stack.push(num);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

}

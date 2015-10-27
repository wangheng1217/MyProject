package wangheng.lintcode;

import java.util.Stack;

public class ExpressionEvaluationSolution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<String> opStack = new Stack<String>();
        for (String exp : expression) {
            if (isNum(exp)) {
                numStack.push(Integer.valueOf(exp));
            } else if ("(".equals(exp)) {
                opStack.push(exp);
            } else if (")".equals(exp)) {
                while (!"(".equals(opStack.peek())) {
                    calculate(numStack, opStack.pop());
                }
                opStack.pop();
            } else if (opStack.isEmpty() || "(".equals(opStack.peek()) 
                        || rank(exp) > rank(opStack.peek())){
                opStack.push(exp);
            } else {
                while (!opStack.isEmpty() && !"(".equals(opStack.peek())
                        && rank(exp) <= rank(opStack.peek())) {
                    calculate(numStack, opStack.pop());
                }
                opStack.push(exp);
            }
        }
        
        while (!opStack.isEmpty()) {
            calculate(numStack, opStack.pop());
        }
        
        return numStack.empty() ? 0 : numStack.pop();
    }
    
    private boolean isNum(String exp) {
        if ("(".equals(exp) || ")".equals(exp) || "+".equals(exp) 
                || "-".equals(exp) || "*".equals(exp) || "/".equals(exp)) 
                return false;
        return true;
    }
    
    private void calculate(Stack<Integer> numStack, String op) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        switch (op) {
            case "+":
                numStack.push(num1 + num2);
                break;
            case "-":
                numStack.push(num1 - num2);
                break;
            case "*":
                numStack.push(num1 * num2);
                break;
            case "/":
                numStack.push(num1 / num2);
                break;
        }
    }
    
    private int rank(String op) {
        switch (op) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
        }
        return 0;
    }
};

package wangheng.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ConvertExpressionToReversePolishNotationSolution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        Stack<List<String>> expStack = new Stack<List<String>>();
        Stack<String> opStack = new Stack<String>();
        for (String exp : expression) {
            if (isNum(exp)) {
                expStack.push(Arrays.asList(new String[] { exp }));
            } else if ("(".equals(exp)) {
                opStack.push(exp);
            } else if (")".equals(exp)) {
                while (!"(".equals(opStack.peek())) {
                    convert(expStack, opStack.pop());
                }
                opStack.pop();
            } else if (opStack.empty() || "(".equals(opStack.peek()) || rank(exp) > rank(opStack.peek())) {
                opStack.push(exp);
            } else {
                while (!opStack.empty() && !"(".equals(opStack.peek()) && rank(exp) <= rank(opStack.peek())) {
                    convert(expStack, opStack.pop());
                }
                opStack.push(exp);
            }
        }
        
        while (!opStack.empty()) {
            convert(expStack, opStack.pop());
        }
        
        return expStack.empty() ? new ArrayList<String>() : new ArrayList<String>(expStack.pop());
    }
    
    private boolean isNum(String exp) {
        try {
            Integer.valueOf(exp);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private void convert(Stack<List<String>> expStack, String op) {
        List<String> result = new ArrayList<String>();
        List<String> exp2 = expStack.pop();
        List<String> exp1 = expStack.pop();
        result.addAll(exp1);
        result.addAll(exp2);
        result.add(op);
        expStack.push(result);
    }
    
    private int rank(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}


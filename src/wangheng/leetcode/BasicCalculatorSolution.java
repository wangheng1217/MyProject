package wangheng.leetcode;

import java.util.Stack;

public class BasicCalculatorSolution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (isNum(c)) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    pushNum(sb.toString(), stack);
                    sb = new StringBuilder();
                }

                if (c == '+' || c == '-' || c == '(') {
                    stack.push(String.valueOf(c));
                } else { // ')'
                    String numStr = stack.pop();
                    stack.pop(); // pop out '('
                    pushNum(numStr, stack);
                }
            }
        }
        
        if (sb.length() > 0) {
            pushNum(sb.toString(), stack);
        }
        
        return stack.isEmpty() ? 0 : Integer.valueOf(stack.pop());
        
    }
    
    private void pushNum(String numStr, Stack<String> stack) {
        int num = Integer.valueOf(numStr);
        if (!stack.isEmpty() && ("+".equals(stack.peek()) || "-".equals(stack.peek()))) {
            String sign = stack.pop();
            if ("+".equals(sign)) {
                num = Integer.valueOf(stack.pop()) + num;
            } else {
                num = Integer.valueOf(stack.pop()) - num;
            }
        }
        stack.push(String.valueOf(num));
    }
    
    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}

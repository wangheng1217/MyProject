package wangheng.lintcode;

import java.util.Stack;

class ExpressionTreeNode {
    public String symbol;
    public ExpressionTreeNode left, right;

    public ExpressionTreeNode(String symbol) {
        this.symbol = symbol;
        this.left = this.right = null;
    }
}

public class ExpressionTreeBuildSolution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        Stack<ExpressionTreeNode> numStack = new Stack<ExpressionTreeNode>();
        Stack<String> opStack = new Stack<String>();
        for (String exp : expression) {
            if (isNum(exp)) {
                numStack.push(new ExpressionTreeNode(exp));
            } else if ("(".equals(exp)) {
                opStack.push(exp);
            } else if (")".equals(exp)) {
                while (!"(".equals(opStack.peek())) {
                    combineNode(numStack, opStack.pop());
                }
                opStack.pop();
            } else if (opStack.isEmpty() || "(".equals(opStack.peek()) 
                        || rank(exp) > rank(opStack.peek())){
                opStack.push(exp);
            } else {
                while (!opStack.isEmpty() && !"(".equals(opStack.peek())
                        && rank(exp) <= rank(opStack.peek())) {
                    combineNode(numStack, opStack.pop());
                }
                opStack.push(exp);
            }
        }
        
        while (!opStack.isEmpty()) {
            combineNode(numStack, opStack.pop());
        }
        
        return numStack.empty() ? null : numStack.pop();
    }
    
    private boolean isNum(String exp) {
        if ("(".equals(exp) || ")".equals(exp) || "+".equals(exp) 
                || "-".equals(exp) || "*".equals(exp) || "/".equals(exp)) 
                return false;
        return true;
    }
    
    private void combineNode(Stack<ExpressionTreeNode> numStack, String op) {
        ExpressionTreeNode node = new ExpressionTreeNode(op);
        node.right = numStack.pop();
        node.left = numStack.pop();
        numStack.push(node);
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
}

package wangheng.leetcode;

import java.util.Stack;

public class WordSearchSolution {
    public boolean exist5(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() == 0) return true;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        Stack<Node> stack = new Stack<Node>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                stack.clear();
                
                Node node = new Node(i, j, 0);
                stack.push(node);
                stack.push(node);

                while (!stack.isEmpty()) {
                    node = stack.pop();
                    if (node.depth == word.length()) return true;
                    
                    if (!stack.isEmpty() && node == stack.peek()) {
                        if (node.i < 0 || node.i >= board.length
                        || node.j < 0 || node.j >= board[0].length
                        || visited[node.i][node.j]
                        || board[node.i][node.j] != word.charAt(node.depth)) {
                            
                            stack.pop();
                        } else {
                            visited[node.i][node.j] = true;
                            
                            Node node1 = new Node(node.i+1, node.j, node.depth+1);
                            Node node2 = new Node(node.i-1, node.j, node.depth+1);
                            Node node3 = new Node(node.i, node.j+1, node.depth+1);
                            Node node4 = new Node(node.i, node.j-1, node.depth+1);
                            
                            stack.push(node1);
                            stack.push(node1);
                            stack.push(node2);
                            stack.push(node2);
                            stack.push(node3);
                            stack.push(node3);
                            stack.push(node4);
                            stack.push(node4);
                        }
                    } else {
                        visited[node.i][node.j] = false;
                    }
                }
            }
        }
        
        return false;
    }

    public boolean exist4(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() == 0) return true;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        Stack<Node> stack = new Stack<Node>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                stack.clear();
                stack.push(new Node(i, j, 0));
                int depth = 0;
                
                while (!stack.isEmpty()) {
                    Node node = stack.peek();
                    if (node.depth == word.length()) return true;
                    
                    if (node.i < 0 || node.i >= board.length
                        || node.j < 0 || node.j >= board[0].length
                        || visited[node.i][node.j]
                        || board[node.i][node.j] != word.charAt(node.depth)) {
                            
                        stack.pop();
                        
                        if (depth > node.depth) {
                            visited[node.i][node.j] = false;
                            depth--;
                        }
                    } else {
                        visited[node.i][node.j] = true;
                        depth++;
                        
                        stack.push(new Node(node.i+1, node.j, depth));
                        stack.push(new Node(node.i-1, node.j, depth));
                        stack.push(new Node(node.i, node.j+1, depth));
                        stack.push(new Node(node.i, node.j-1, depth));
                    }
                }
            }
        }
        
        return false;
    }

    private class Node {
        int i;
        int j;
        int depth;
        Node (int i, int j, int depth) {
            this.i = i;
            this.j = j;
            this.depth = depth;
        }
    }    
    public boolean exist3(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() == 0) return true;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, visited, 0)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited, int p) {
        if (word.length() == p) return true;
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(p)) return false;
        
        visited[i][j] = true;
        
        boolean found = dfs(board, word, i+1, j, visited, p+1)
                        || dfs(board, word, i-1, j, visited, p+1)
                        || dfs(board, word, i, j+1, visited, p+1)
                        || dfs(board, word, i, j-1, visited, p+1);
                        
        visited[i][j] = false;
        
        return found;
    }

    public boolean exist2(char[][] board, String word) {
        if (word.length() == 0) return true;
        
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word, used)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, int depth, String word, boolean[][] used) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(depth)) return false;
        if (used[i][j]) return false;
        
        if (depth == word.length()-1) return true;
        
        used[i][j] = true;
        
        if (dfs(board, i-1, j, depth+1, word, used)) return true;
        if (dfs(board, i+1, j, depth+1, word, used)) return true;
        if (dfs(board, i, j-1, depth+1, word, used)) return true;
        if (dfs(board, i, j+1, depth+1, word, used)) return true;
        
        used[i][j] = false;
        
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0)
            return "".equals(word) ? true : false;
        int[][] map = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean exist = exist(board, word, map, i, j, 0);
                if (exist)
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int[][] map,
            int rowIndex, int colIndex, int strIndex) {

        if (strIndex >= word.length())
            return true;

        if (rowIndex < 0 || rowIndex >= board.length || colIndex < 0
                || colIndex >= board[0].length)
            return false;

        if (map[rowIndex][colIndex] == 1)
            return false;

        char c = board[rowIndex][colIndex];

        if (c != word.charAt(strIndex))
            return false;

        map[rowIndex][colIndex] = 1;

        if (exist(board, word, map, rowIndex, colIndex - 1, strIndex + 1))
            return true;
        if (exist(board, word, map, rowIndex, colIndex + 1, strIndex + 1))
            return true;
        if (exist(board, word, map, rowIndex - 1, colIndex, strIndex + 1))
            return true;
        if (exist(board, word, map, rowIndex + 1, colIndex, strIndex + 1))
            return true;

        map[rowIndex][colIndex] = 0;
        return false;
    }

}

package wangheng.leetcode;

import java.util.HashMap;

public class SudokuSolverSolution {
    private HashMap<Character, Boolean>[] rowMaps = new HashMap[9];
    private HashMap<Character, Boolean>[] colMaps = new HashMap[9];
    private HashMap<Character, Boolean>[] blockMaps = new HashMap[9];

    public void solveSudoku3(char[][] board) {
        fill(rowMaps);
        fill(colMaps);
        fill(blockMaps);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                popMap(board[i][j], i, j);
            }
        }
        
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(c, i, j)) {
                            board[i][j] = c;
                            popMap(c, i, j);
                            if (solve(board)) return true;
                            else {
                                board[i][j] = '.';
                                eraseMap(c, i, j);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char c, int i, int j) {
        if (rowMaps[i].get(c) != null) return false;
        if (colMaps[j].get(c) != null) return false;
        if (blockMaps[(i/3)*3 + (j/3)].get(c) != null) return false;
        return true;
    }
    
    private void popMap(char c, int i, int j) {
        rowMaps[i].put(c, true);
        colMaps[j].put(c, true);
        blockMaps[(i/3)*3 + (j/3)].put(c, true);
    }
    
    private void eraseMap(char c, int i, int j) {
        rowMaps[i].put(c, null);
        colMaps[j].put(c, null);
        blockMaps[(i/3)*3 + (j/3)].put(c, null);
    }
    
    private void fill(HashMap<Character, Boolean>[] maps) {
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<Character, Boolean>();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }
        new SudokuSolverSolution().solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int row, int col) {
        boolean found = false;
        int x = 0, y = 0;
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == row && j < col)
                    j = col;
                if (board[i][j] == '.') {
                    found = true;
                    x = i;
                    y = j;
                    break;
                }
            }
            if (found)
                break;
        }
        if (!found)
            return true;

        for (int i = 0; i < 9; i++) {
            board[x][y] = (char) ((int) '1' + i);
            //boolean valid = isValidSudoku(board);
            boolean valid = isValidSudoku(board, x, y);
            if (!valid)
                continue;
            else {
                boolean b = solveSudoku(board, x, y);
                if (b == true)
                    return true;
            }
        }
        board[x][y] = '.';
        return false;
    }
    
    private boolean isValidSudoku(char[][] board, int x, int y) {
        boolean isValid = isValid(board[x]);
        if(!isValid) return false;
        
        char[] column = new char[9];
        for(int i = 0; i < 9; i++) {
            column[i] = board[i][y];
        }
        isValid = isValid(column);
        if(!isValid) return false;
        
        char[] block = new char[9];
        int blockX = (x/3)*3;
        int blockY = (y/3)*3;
        for(int i = 0; i < 9; i++) {
            block[i] = board[blockX + i/3][blockY + i%3];
        }
        isValid = isValid(block);
        if(!isValid) return false;
        
        return true;
    }

    private boolean isValidSudoku(char[][] board) {
        if (board.length != 9)
            return false;
        if (board[0].length != 9)
            return false;

        for (int i = 0; i < 9; i++) {
            boolean isValid = isValid(board[i]);
            if (!isValid)
                return false;

            char[] column = new char[9];
            for (int j = 0; j < 9; j++) {
                column[j] = board[j][i];
            }
            isValid = isValid(column);
            if (!isValid)
                return false;

            char[] block = new char[9];
            for (int j = 0; j < 9; j++) {
                block[j] = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3];
            }
            isValid = isValid(block);
            if (!isValid)
                return false;
        }

        return true;
    }

    private boolean isValid(char[] row) {
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<Character, Integer>();
        for (int i = 0; i < row.length; i++) {
            char c = row[i];
            if (c >= '1' && c <= '9') {
                Integer inte = map.get(c);
                if (inte == null) {
                    map.put(c, 1);
                } else
                    return false;
            }
        }
        return true;
    }

}

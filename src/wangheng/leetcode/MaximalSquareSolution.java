package wangheng.leetcode;

public class MaximalSquareSolution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int rows = matrix.length, cols = matrix[0].length;
        
        int[][] sq = new int[rows+1][cols+1];
        int maxSq = 0;
        
        for (int i = rows-1; i >= 0; i--) {
            for (int j = cols-1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    sq[i][j] = Math.min(Math.min(sq[i+1][j], sq[i][j+1]), sq[i+1][j+1])+1;
                    maxSq = Math.max(maxSq, sq[i][j]);
                }
            }
        }
        
        return maxSq*maxSq;
    }
}

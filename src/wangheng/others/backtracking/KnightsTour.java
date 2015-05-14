package wangheng.others.backtracking;

/*
 * http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 */
public class KnightsTour {
    
    public static void main(String[] args) {
        new KnightsTour().solveKT(0, 0);
    }
    
    public void solveKT(int x, int y) {
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
        int n = 8;
        int[][] solution = new int[n][n];
        if (solveKT(0, 0, xMove, yMove, solution, n, 1)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(solution[i][j]);
                    if (j == n-1) System.out.print("\n");
                    else System.out.print("\t");
                }
            }
        } else {
            System.out.println("not resolvable");
        }
    }
    
    private boolean solveKT(int x, int y, int[] xMove, int[] yMove, int[][] solution, int n, int count) {
        solution[x][y] = count;
        
        if (count == n*n) return true;
//        {
//            if ( (x == 1 && y == 2) || (x == 2 && y == 1) ) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(solution[i][j]);
//                    if (j == n-1) System.out.print("\n");
//                    else System.out.print("\t");
//                }
//            }
//            solution[x][y] = 0;
//            return false;
//        }
        
        for (int i = 0; i < 8; i++) {
            int newX = x + xMove[i];
            int newY = y + yMove[i];
            if (newX >= 0 && newX < n && newY >= 0 && newY < n && solution[newX][newY] == 0) {
                if (solveKT(newX, newY, xMove, yMove, solution, n, count+1)) {
                    return true;
                }
            }
        }
        
        solution[x][y] = 0;
        
        return false;
    }
}

package wangheng.lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrixSolution {
    
    /*
    private int m;
    private int n;
    
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0 || k <= 0 || k > matrix.length * matrix[0].length) throw new IllegalArgumentException("invalid input");
        m = matrix.length;
        n = matrix[0].length;
        if (k == 1) return matrix[0][0];
        if (k == matrix.length * matrix[0].length) return matrix[m-1][n-1];
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(n, new PointComparator(matrix));
        
        for (int j = 0; j < n; j++) heap.offer(getPos(0, j));
        int pos;
        for (int i = 2; i <= k; i++) {
            pos = heap.poll();
            if (pos + n < m*n) heap.offer(pos+n);
        }
        
        pos = heap.poll();
        return matrix[getX(pos)][getY(pos)];
    }

    private int getPos(int x, int y) {
        return x*n + y;
    }
    
    private int getX(int pos) {
        return pos/n;
    }
    
    private int getY(int pos) {
        return pos%n;
    }
    
    class PointComparator implements Comparator<Integer> {
        int[][] matrix;
        
        PointComparator(int[][] matrix) {
            this.matrix = matrix;
        }
        
        @Override
        public int compare(Integer a, Integer b) {
            return matrix[getX(a)][getY(a)] - matrix[getX(b)][getY(b)];
        }
    }
     */
    
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0 || k <= 0 || k > matrix.length * matrix[0].length) throw new IllegalArgumentException("invalid input");
        if (k == 1) return matrix[0][0];
        if (k == matrix.length * matrix[0].length) return matrix[matrix.length-1][matrix[0].length-1];
        
        PriorityQueue<Point> heap = new PriorityQueue<Point>(new PointComparator(matrix));
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        heap.offer(new Point(0, 0));
        visited[0][0] = true;
        Point p = null;
        for (int i = 2; i <= k; i++) {
            p = heap.poll();
            offer(heap, p.x+1, p.y, visited);
            offer(heap, p.x, p.y+1, visited);
        }
        
        p = heap.poll();
        return matrix[p.x][p.y];
    }
    
    private void offer(PriorityQueue<Point> heap, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= visited.length || y < 0 || y >= visited[0].length || visited[x][y]) return;
        visited[x][y] = true;
        heap.offer(new Point(x, y));
    }
}
    
    class PointComparator implements Comparator<Point> {
        int[][] matrix;
        
        PointComparator(int[][] matrix) {
            this.matrix = matrix;
        }
        
        @Override
        public int compare(Point a, Point b) {
            return matrix[a.x][a.y] - matrix[b.x][b.y];
        }
    }
    
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

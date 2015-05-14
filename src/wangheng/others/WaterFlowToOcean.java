package wangheng.others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32833017.html
 * 
 * 从同学那边问来的一道Google面经题

 输入是一个 N*N的矩阵，代表地势高度（elevation）。然后如果下雨，水流只能流去
 比他矮或者一样高的地势。矩阵上边和左边是太平洋，下边和右边是大西洋。求出所有
 的能同时流到两个大洋的点。

 求讨论，求指导。 

 */
public class WaterFlowToOcean {
    
    public static void main(String[] args) {
        WaterFlowToOcean solution = new WaterFlowToOcean();
        
        int[][] map = {
                {2, 2, 2, 2, 2, 2, 2, 3},
                {2, 1, 1, 1, 1, 1, 3, 1},
                {2, 2, 1, 1, 1, 1, 3, 2},
                {2, 2, 3, 4, 5, 6, 2, 1},
                {2, 2, 1, 4, 1, 1, 1, 2},
                {2, 1, 1, 4, 1, 1, 1, 2},
                {2, 1, 1, 4, 1, 1, 1, 2},
                {3, 2, 2, 2, 2, 2, 2, 2},
        };
        
        System.out.println(solution.canFlow(map));
    }
    
    public List<Node> canFlow(int[][] map) {
        int n = map.length;

        Queue<Node> queue = new LinkedList<Node>();

        boolean[][] canFlowToLeft = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            canFlowToLeft[0][i] = true;
            queue.add(new Node(0, i));
        }
        for (int i = 1; i < n; i++) {
            canFlowToLeft[i][0] = true;
            queue.add(new Node(i, 0));
        }
        bfs(map, canFlowToLeft, queue);

        queue.clear();
        boolean[][] canFlowToRight = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            canFlowToRight[n - 1][i] = true;
            queue.add(new Node(n - 1, i));
        }
        for (int i = 0; i < n - 1; i++) {
            canFlowToRight[i][n - 1] = true;
            queue.add(new Node(i, n - 1));
        }
        bfs(map, canFlowToRight, queue);

        List<Node> result = new ArrayList<Node>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (canFlowToLeft[i][j] && canFlowToRight[i][j]) {
                    result.add(new Node(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] map, boolean[][] canFlow, Queue<Node> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                addToQueue(map, canFlow, queue, node.x + 1, node.y, node);
                addToQueue(map, canFlow, queue, node.x - 1, node.y, node);
                addToQueue(map, canFlow, queue, node.x, node.y + 1, node);
                addToQueue(map, canFlow, queue, node.x, node.y - 1, node);
            }
        }
    }

    private void addToQueue(int[][] map, boolean[][] canFlow, Queue<Node> queue, int x, int y, Node node) {
        int n = map.length;
        if (x >= 0 && x < n && y >= 0 && y < n && !canFlow[x][y] && map[x][y] >= map[node.x][node.y]) {
            canFlow[x][y] = true;
            queue.add(new Node(x, y));
        }

    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}

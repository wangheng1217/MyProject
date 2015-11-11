package wangheng.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIISolution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> resultSet = new HashSet<String>();

        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.getChild(c) == null)
                    node.setChild(c, new TrieNode());
                node = node.getChild(c);
            }
            node.setItem(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, new boolean[board.length][board[0].length], resultSet);
            }
        }

        return new ArrayList<String>(resultSet);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, boolean[][] visited, Set<String> resultSet) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
            return;

        TrieNode child = node.getChild(board[i][j]);
        if (child != null) {
            if (child.getItem() != null)
                resultSet.add(child.getItem());

            visited[i][j] = true;

            dfs(board, i + 1, j, child, visited, resultSet);
            dfs(board, i - 1, j, child, visited, resultSet);
            dfs(board, i, j + 1, child, visited, resultSet);
            dfs(board, i, j - 1, child, visited, resultSet);

            visited[i][j] = false;
        }
    }

    class TrieNode {
        String item;
        TrieNode[] children = new TrieNode[26];

        TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        void setChild(char c, TrieNode node) {
            children[c - 'a'] = node;
        }

        String getItem() {
            return this.item;
        }

        void setItem(String item) {
            this.item = item;
        }
    }
}

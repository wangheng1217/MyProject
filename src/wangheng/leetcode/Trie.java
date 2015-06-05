package wangheng.leetcode;

class TrieNode {
    char c;
    boolean isEnd;
    TrieNode[] children;

    // Initialize your data structure here.
    public TrieNode(char c) {
        this.c = c;
        this.isEnd = false;
        this.children = new TrieNode[26];
    }

    public TrieNode getChild(char c) {
        return this.children[c - 'a'];
    }

    public void setChild(char c, TrieNode node) {
        this.children[c - 'a'] = node;
    }

}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.getChild(c) == null)
                node.setChild(c, new TrieNode(c));
            node = node.getChild(c);
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.getChild(c);
            if (node == null)
                return false;
        }
        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.getChild(c);
            if (node == null)
                return false;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
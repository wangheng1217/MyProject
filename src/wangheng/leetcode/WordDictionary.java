package wangheng.leetcode;

public class WordDictionary {

    private TrieNode root = new TrieNode(' ');

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.getChild(c) == null) node.setChild(c, new TrieNode(c));
            node = node.getChild(c);
        }
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int p, TrieNode node) {
        if (p == word.length()) return node != null && node.isEnd;
        
        if (node == null) return false;
        
        if (word.charAt(p) == '.') {
            for (char c = 'a'; c <= 'z'; c++) {
                if (search(word, p+1, node.getChild(c))) return true;
            }
            return false;
        } else {
            return search(word, p+1, node.getChild(word.charAt(p)));
        }
    }
    
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
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
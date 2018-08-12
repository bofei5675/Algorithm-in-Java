package Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Insert a word to TrieTree Space Complexity is O(m), Time Complexity is
     * O(m) where m is the length of word
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode node = this.root;
        // continue to add nodes to links
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        // set end if the word is end
        node.setEnd(true);

    }

    public boolean search(String word) {
        TrieNode temp = this.root;
        // iterate each char to see if we can find the char
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.containsKey(c)) {
                temp = temp.get(c);
            } else {
                return false;
            }
        }

        return temp.isEnd();
    }

    public boolean startsWith(String word) {
        TrieNode temp = this.root;
        // iterate each char to see if we can find the char
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.containsKey(c)) {
                temp = temp.get(c);
            } else {
                return false;
            }
        }
        // does not matter if this char is or not end
        return true;
    }
}

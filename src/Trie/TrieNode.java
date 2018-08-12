package Trie;

public class TrieNode {
    // neighbors of this node
    private TrieNode[] links;
    // Total 26 links since input is from a to z
    final private int R = 26;

    private boolean isEnd;

    /**
     * Need 3 methods containsKey(char c) and get() put()
     */
    /**
     * Check if this TrieNode is connected to certain characters.
     *
     * @param c
     * @return
     */
    public boolean containsKey(char c) {
        return this.links[c - 'a'] != null;
    }

    /**
     * get the children based on given char
     */
    public TrieNode get(char c) {

        return this.links[c - 'a'];
    }

    /**
     * Put this character into array
     *
     * @param c
     * @param node
     */
    public void put(char c, TrieNode node) {

        this.links[c - 'a'] = node;
    }

    /**
     * Constructor for this node
     */
    public TrieNode() {
        this.links = new TrieNode[this.R];
    }

    public TrieNode[] getLinks() {
        return this.links;
    }

    public void setLinks(TrieNode[] links) {
        this.links = links;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public int getR() {
        return this.R;
    }

}

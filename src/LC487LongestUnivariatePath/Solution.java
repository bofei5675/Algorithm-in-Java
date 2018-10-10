package LC487LongestUnivariatePath;

class Solution {
	/**
	 * find the longest path that all nodes with same variables
	 * use dfs
	 * @param root
	 * @return
	 */
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
        dfs(root,res);
        return res[0];
    }
    
    private int dfs(TreeNode node, int[] res){
        if(node == null) return 0;
        // go left then go right
        // if the node on the left or right is 0 just return 0
        int node_left = node.left != null ? dfs(node.left,res): 0 ;
        int node_right = node.right != null ? dfs(node.right, res): 0;
        // if the left var == root.val, then longest path will be node_left + 1
        // if not equal, then make them equal to 0.
        int left = node.left != null && node.left.val == node.val ? node_left + 1 : 0;
        int right = node.right != null && node.right.val == node.val ? node_right + 1 : 0;
        
        //
        res[0] = Math.max(res[0], left + right);
        
        return Math.max(left,right);
        
    }
    
    
}
class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
}
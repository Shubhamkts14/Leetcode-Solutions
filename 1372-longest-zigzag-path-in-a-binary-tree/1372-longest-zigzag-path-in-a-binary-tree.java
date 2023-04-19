/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxZigzag = 0;
    
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return maxZigzag;
    }
    
    public void dfs(TreeNode node, boolean isLeft, int len) {
        if (node == null) {
            maxZigzag = Math.max(maxZigzag, len - 1);
            return;
        }
        if (isLeft) {
            dfs(node.right, false, len + 1);
            dfs(node.left, true, 1);
        } else {
            dfs(node.left, true, len + 1);
            dfs(node.right, false, 1);
        }
    }
}

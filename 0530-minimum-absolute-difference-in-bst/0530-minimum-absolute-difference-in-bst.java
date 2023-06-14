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

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            int diff = Math.abs(values.get(i) - values.get(i - 1));
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> values) {
        if (root == null)
            return;
        
        inOrderTraversal(root.left, values);
        values.add(root.val);
        inOrderTraversal(root.right, values);
    }
}

// Runtime: 0 ms
// Memory Usage: 38.7 MB
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }
    
    int depth(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        return Math.max(depth(root.left, depth), depth(root.right, depth))+1;
    }
}

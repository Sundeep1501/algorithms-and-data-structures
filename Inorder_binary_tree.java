// Runtime: 0 ms
// Memory Usage: 34.6 MB
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<TreeNode> stack = new ArrayList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        
        while(root!=null){
            stack.add(root);
            root = root.left;
        }
        
        while(stack.size() > 0){
            int lastItemIndex = stack.size()-1;
            TreeNode node = stack.remove(lastItemIndex);
            result.add(node.val);
            node = node.right;
            
            while(node!=null){
                stack.add(node);
                node = node.left;
            }
        }
        return result;
    }
}

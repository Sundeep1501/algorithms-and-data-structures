// Runtime: 0 ms
// Memory Usage: 34.7 MB
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
    // Pre order traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<TreeNode> stack = new ArrayList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        traversLeft(stack, result, root);
        while(stack.size() > 0){
            int lastItemIndex = stack.size()-1;
            TreeNode node = stack.remove(lastItemIndex);
            if(node.right!=null){
                traversLeft(stack, result, node.right);
            }
        }
        return result;
    }
    
    void traversLeft(List<TreeNode> stack, List<Integer> result, TreeNode root){
        if(root != null){
            // print root
            stack.add(root);
            result.add(root.val);
            
            TreeNode left = root.left;
            while(left != null){
                // print left
                stack.add(left);
                result.add(left.val);
                root = left;
                left = root.left;
            }
        }
    }
}

// Runtime: 1 ms
// Memory Usage: 35 MB
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> stack = new ArrayList<TreeNode>();
        
        stack.addAll(getAllLeftNodes(root));
        
        TreeNode lastTreeNode = null;
        while(stack.size() > 0){
            int lastItemIndex = stack.size()-1;
            root = stack.get(lastItemIndex);
            TreeNode right = root.right;
            if(right == null || right == lastTreeNode){
                result.add(root.val);
                lastTreeNode = root;
                stack.remove(lastItemIndex);
            } else {
                stack.addAll(getAllLeftNodes(right));
            }
        }
        return result;
    }
    
    List<TreeNode> getAllLeftNodes(TreeNode root){
        List<TreeNode> list = new ArrayList<TreeNode>();
        while(root!=null){
            list.add(root);
            root = root.left;
        }
        
        return list;
    }
}

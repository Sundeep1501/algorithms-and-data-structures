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
    public boolean hasPathSum(TreeNode root, int sum) {
        int stackValue = 0;
        Stack<TreeNode> stack = new Stack();
        
        while(root!=null){
            stack.add(root);
            stackValue+=root.val;
            root = root.left;
        }
        TreeNode lastNode = null;
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.right == null && node.left == null){
                if(stackValue == sum){
                    return true;
                }
                lastNode = stack.pop();
                stackValue-=lastNode.val;
            } else if (node.right == null || node.right == lastNode){
                lastNode = stack.pop();
                stackValue-=lastNode.val;
            } else {
                node = node.right;
                while(node!=null){
                    stack.add(node);
                    stackValue+=node.val;
                    node = node.left;
                }
            }
        }
        return false;
    }
}

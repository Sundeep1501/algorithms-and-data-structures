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
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();    
        level.add(root);
        
        while(level!=null){
            List<TreeNode> newLevel = new ArrayList<>();
            
            for(TreeNode node : level){
                if(node == null){
                    newLevel.add(null);
                    newLevel.add(null);
                } else {
                    newLevel.add(node.left);
                    newLevel.add(node.right);
                }
            }
                   
            int half = newLevel.size()/2;
            int size = newLevel.size();
            boolean isEmpty = true;
            for(int i = 0; i < half;i++){
                TreeNode left = newLevel.get(i);
                TreeNode right = newLevel.get(size-1-i);
                if(left == null && right == null){
                    continue;
                }
                isEmpty = false;
                if(left == null || right == null){
                    return false;
                } else if(left.val == right.val){
                    continue;
                } else {
                    return false;
                }
            }
            if(isEmpty){
                break;
            }else{
                level = newLevel;
            }
        }
        return true;
    }
}

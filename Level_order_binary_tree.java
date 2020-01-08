// Runtime: 1 ms
// Memory Usage: 36.2 MB
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        
        if(root!=null){
            List<Integer> level1 = new ArrayList<Integer>();
            level1.add(root.val);
            queue.add(root);
            result.add(level1);
        }
       
        
        for (int i=0;i<result.size();i++){
            List<Integer> list = result.get(i);
            List<Integer> level = new ArrayList<Integer>();
            for(Integer item:list){
                TreeNode node = queue.poll();
                if(node!=null){
                    TreeNode left = node.left;
                    if(left!=null){
                        queue.add(left);
                        level.add(left.val);
                    }
                    
                    TreeNode right = node.right;
                    if(right!=null){
                        queue.add(right);
                        level.add(right.val);
                    }
                }
            }
            if(level.size()>0){
                result.add(level);    
            }
            
        }
        return result;
    }
}

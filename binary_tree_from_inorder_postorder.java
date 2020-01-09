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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(toArrayList(inorder),toArrayList(postorder));
    }
    
    public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if(postorder.size()==0){
            return null;
        }
        TreeNode root = new TreeNode(postorder.get(postorder.size()-1));
        List<Integer> leftSubTree = new ArrayList<>();
        List<Integer> rightSubTree = new ArrayList<>();
        
        int rootIndex = inorder.indexOf(root.val);
        
        leftSubTree = inorder.subList(0, rootIndex);
        rightSubTree = inorder.subList(rootIndex+1, inorder.size());
        
        int rightStartIndex = 0;
        if(leftSubTree.size() != 0){
            if(rightSubTree.size()==0){
                rightStartIndex = postorder.size()-1;
            } else {
                rightStartIndex = leftSubTree.size();    
            }
            
            root.left = buildTree(leftSubTree, postorder.subList(0, rightStartIndex));
        }
        
        if(rightSubTree.size() != 0){
            root.right = buildTree(rightSubTree, postorder.subList(rightStartIndex, postorder.size()-1));
        } 
        return root;
    }
    
    List<Integer> toArrayList(int[] ints){
       List<Integer> intList = new ArrayList<Integer>(ints.length);
       for (int i : ints){
           intList.add(i);
       }
        return intList;
   }

}

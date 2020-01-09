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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(toArrayList(inorder), toArrayList(preorder));
    }
    
    public TreeNode buildTree(List<Integer> inorder, List<Integer> preorder) {
        if(preorder.size()==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder.get(0));
        List<Integer> leftSubTree = new ArrayList<>();
        List<Integer> rightSubTree = new ArrayList<>();
        
        int rootIndex = inorder.indexOf(root.val);
        
        leftSubTree = inorder.subList(0, rootIndex);
        rightSubTree = inorder.subList(rootIndex+1, inorder.size());
        
        int rightStartIndex;
        if(leftSubTree.size() != 0){
            rightStartIndex = leftSubTree.size()+1;
            root.left = buildTree(leftSubTree, preorder.subList(1,rightStartIndex));
        } else {
            rightStartIndex = 1;
        }
        if(rightSubTree.size() != 0){
            root.right = buildTree(rightSubTree, preorder.subList(rightStartIndex, preorder.size()));
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

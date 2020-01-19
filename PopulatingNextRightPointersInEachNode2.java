/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root != null){
            Queue<Node> cLevel = new LinkedList<>(); 
            cLevel.add(root);
            
            Queue<Node> nLevel = new LinkedList<>(); 
            while(cLevel.peek()!=null){
                Node node = cLevel.poll();
                if(node.left!=null){
                    nLevel.add(node.left);    
                } 
                if(node.right!=null) {
                    nLevel.add(node.right);
                }
                if(cLevel.peek() == null){
                    cLevel = nLevel;
                    nLevel = new LinkedList<>();
                } else {
                    node.next = cLevel.peek();
                }
            }
        }
        return root;
    }
}

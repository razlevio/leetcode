/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CountGoodNodes {
    class Node {
        TreeNode treeNode;
        int max = Integer.MIN_VALUE;
        public Node(TreeNode n, int mx) {
            treeNode = n;
            max = Math.max(mx, n.val);
        }
    }
        
        public int goodNodes(TreeNode root) {
            Deque<Node> x = new ArrayDeque<>();
            x.push(new Node(root, root.val));
            int c = 0;
            while (!x.isEmpty()) {
                Node current = x.pop();
                c += current.treeNode.val >= current.max ? 1 : 0;
                for (TreeNode child : new TreeNode[]{current.treeNode.left, current.treeNode.right}) {
                    if (child != null) {
                        x.push(new Node(child, current.max));
                    }
                }
            }
            return c;
        } 
}

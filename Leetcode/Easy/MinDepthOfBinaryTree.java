package Easy;

public class MinDepthOfBinaryTree {


  //Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
  }
    public int minDepth(TreeNode root) {

      // My solution Runtime > 95%  Space > 100%
        /** Queue<TreeNode> q1 = new LinkedList<>();
         if(root == null) return 0;
         root.val = 1;
         q1.offer(root);
         int ans = 0;
         while(q1.size() != 0){
         TreeNode val = q1.poll();
         if(val.left != null){
         val.left.val = val.val + 1;
         q1.offer(val.left);
         }
         if(val.right != null){
         val.right.val = val.val + 1;
         q1.offer(val.right);
         }
         if(val.left == null && val.right == null){
         ans = val.val;
         break;
         }
         }
         return ans;**/

        // Alt solution Runtime > 100% Space > 100%
        if(root==null)return 0;
        if(root.left==null)return minDepth(root.right)+1;
        if(root.right==null)return minDepth(root.left)+1;

        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
}

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 */
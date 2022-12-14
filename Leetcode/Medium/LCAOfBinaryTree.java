/*

    12/09/2022

    Least Common Ancestor of Binary Tree
    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

    BST
        - Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
        – Unordered

    Approach:
        1) Find one target node, add to queue* in postorder traversal DFS.
        2) Find the second target node, add to a second queue in postorder traversal DFS.
        3) The queue size represents the level of the node. Poll queues until the sizes are equal.
        4) Compare the nodes at the head of each queue until the match, then return matching node.

    Timeline:
        13:00            Implemented solution. Failed 1 of 3 basic test cases.
        17:30            Recognized misuse of data structure and switched from Stack to Queue.
        TIMED OUT(20:00) Debugging
        +5min            Fixed misspelled variable that was used in comparison logic. NOTE: Make variable names more
                            distinct. pQue and qQue are easy to overlook during debugging.


    Big O Analysis
        Time: Beats 55.11% O(2N) ~> O(N)
        Space: Beats 12.29% O(2N) ~> O(N)

    Discussion:
        Space optimization:
            Optimize by only using one queue. Build queue on one target node like what is done here.
        When second node is found, instead of building onto another queue, begin to poll from first queue, and do the comparison
        during the "return to root" phase of the recursion.

        Time optimization:
            Instead of starting from root node again for second node, do a single full DFS looking for both nodes.
*/

public class LCAofBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    // double dfs w/ postorder traversal

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> pQue = new LinkedList<>();
        Queue<TreeNode> qQue = new LinkedList<>();
        dfs(root, p, pQue);
        Queue<TreeNode> newPQue = new LinkedList<>();
        // while(pQue.size() > 0) {
        //     TreeNode node = pQue.poll();
        //     System.out.print(node.val + " -> ");
        //     newPQue.offer(node);
        //}
        // System.out.println(" ");
        dfs(root, q, qQue);
        Queue<TreeNode> newQQue = new LinkedList<>();
        // while(qQue.size() > 0) {
        //     TreeNode node = qQue.poll();
        //     System.out.print(node.val + " -> ");
        //     newQQue.offer(node);
        // }
        // System.out.println(" ");
        while(qQue.size() > pQue.size()) {
            qQue.poll();
        }
        while(pQue.size() > qQue.size()) {
            pQue.poll();
        }
        while(pQue.size() > 0 && qQue.size() > 0 && pQue.peek() != qQue.peek()) {
            qQue.poll();
            pQue.poll();
        }
        if(pQue.size() == 0 || qQue.size() == 0) return root;
        return pQue.poll();
    }

    public static void dfs(TreeNode root, TreeNode target, Queue<TreeNode> que) {
        if(root.val == target.val) {
            que.offer(root);
            return;
        }
        if(root.left != null) {
            dfs(root.left, target, que);
            if(que.size() != 0) {
                que.offer(root);
                return;
            }
        }
        if(root.right != null) {
            dfs(root.right, target, que);
            if(que.size() != 0) {
                que.offer(root);
                return;
            }
        }
        return;
    }
}
/*
    12/08/2022

    230. Kth Smallest Element in a BST
    https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

    BST
        - ordered, not balanced
        - smallest on leftmost side
        - head is "midpoint"
    #BST #InorderTraversal

    Approach:
        1) Find the smallest element #1
        2) Do inorder traversal w/ counter once current node is null/at leaf node.

        (2)                 (4)                         (5)
      (1)  (3)           (2)    (5)                 (3)     (6)
                       (1) (3)                    (2) (4)
                                                (1)

Timeline:
    Implemented and passed 3 basic testcases in 12:00 min.
    Submitted at 15:45 min.

Difficulty: Medium

Big O Analysis
Time: Beat 100%. O(n)
Space: Beat 86.62% O(1)

Discussion:
    Q: If insert and delete on tree is often. how do we optimize to find the kth smallest element frequently?
    A: With each insert or delete on the left branch of current kth smalelst, we update a variable the tracks
    the kth smallest node.

    Further topic: Threaded binary tree is useful for faster accessing ancestors in tree without stacks or recursion.
                    Helpful in inorder traversal.
                    No null nodes. Nodes with no children point to the inorder predecessor, if left leaf, or
                    inorder successor, if right leaf.
*/

class KthSmallestInBST {

     // Definition for a binary tree node.
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
        int c = 0;
        public int kthSmallest(TreeNode root, int k) {
            return kthSmallestSearch(root, k);
        }

        public int kthSmallestSearch(TreeNode root, int k) {
            if(root.left != null) {
                int val = kthSmallestSearch(root.left, k);
                if(val != -1) return val;
            }
            c++;
            if(c == k) {
                return root.val;
            }
            if(root.right != null) {
                int val = kthSmallestSearch(root.right, k);
                if(val != -1) return val;
            }
            return -1;
        }
    }
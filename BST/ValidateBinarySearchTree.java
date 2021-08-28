/*
https://leetcode.com/problems/validate-binary-search-tree/


Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1


key points:

A binary search tree (BST) is a node based binary tree data structure which has the following properties. 
• The left subtree of a node contains only nodes with keys less than the node’s key. 
• The right subtree of a node contains only nodes with keys greater than the node’s key. 
• Both the left and right subtrees must also be binary search trees.
From the above properties it naturally follows that: 
• Each node (item in the tree) has a distinct key.


descriptions:

for left subtree all values should be less than max
for right subtree all values should be greater than min
https://www.youtube.com/watch?v=OZPq1FoDAWo&t=3s


*/


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
class Solution {
    
    public boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        else if(min != null && min >= root.val || max != null && max <= root.val) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}

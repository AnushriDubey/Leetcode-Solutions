/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100


Idea:

Use two stacks to keep the left to right and right to left nodes to process them according to ask.


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
    
    static Stack<TreeNode> lR;
    static Stack<TreeNode> rL;
    static List<List<Integer>> ll;
    
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ll = new ArrayList<>();
        if(root==null) return ll;
        lR = new Stack<>();
        rL = new Stack<>();
        rL.push(root);
        while(!lR.isEmpty() || !rL.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            if(!rL.isEmpty()) {
                while(!rL.isEmpty()) {
                    TreeNode head = rL.peek();
                    rL.pop();
                    tmp.add(head.val);
                    if(head.left != null) lR.push(head.left);
                    if(head.right != null) lR.push(head.right);
                }
            }
            else {
                while(!lR.isEmpty()) {
                    TreeNode head = lR.peek();
                    lR.pop();
                    tmp.add(head.val);
                    if(head.right != null) rL.push(head.right);
                    if(head.left != null) rL.push(head.left);
                }
            }
            ll.add(tmp);
        }
        return ll;
    }
}

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.


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
    static TreeNode root, curr;
    public static TreeNode create(int []p, int in[], int il, int ir, int pl, int pr) {
        if(il>ir || pl>pr) return null;
        //System.out.println(il + " " + ir + " " + pl + " " + pr + " ");
        int tmp = 0;
        for(int i = il;i<=ir;i++) {
            if(in[i] == p[pl]) {
                tmp = i;
                break;
            }
        }
        TreeNode cur = new TreeNode(in[tmp]);
        if(root == null) root = cur;
        int len = tmp - il;
        // System.out.println("left "+ len + " " + il + " " + (tmp -1) + " " + (pl+1) + " " + (pl+len) + " ");
        // System.out.println("right "+ len + " " + (tmp+1) + " " + (ir) + " " + (pl+len+1) + " " + (pr) + " ");
        cur.left = create(p, in, il, tmp-1, pl+1, pl+len);
        cur.right = create(p, in, tmp+1, ir, pl+len+1, pr);
        return cur;
    }
    
    
    public TreeNode buildTree(int[] p, int[] in) {
        return create(p, in, 0, in.length-1, 0, p.length-1);
    }
}

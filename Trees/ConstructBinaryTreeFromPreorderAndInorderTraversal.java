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
    
    public TreeNode construct(int in[], int pre[], int is, int ie, int ps, int pe) {
        if(is>ie || ps>pe) return null;
        TreeNode curr = new TreeNode(pre[ps]);
        int tmp = is;
        for(int i=is;i<=ie;i++) {
            if(pre[ps]==in[i]) {
                tmp = i;
                break;
            }
        }
        int leftLen = tmp - is;
        curr.left = construct(in, pre, is, tmp-1, ps+1, ps+leftLen);
        curr.right = construct(in, pre, tmp+1, ie, ps+leftLen+1, pe);
        return curr;
    }
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
    }
}

/*
https://leetcode.com/problems/delete-node-in-a-bst/

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Follow up: Can you solve it with time complexity O(height of tree)?

 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105


*/


/*

There are three cases to BST deletion:

case 1: key is child node directly change it to null;

case 2: key node have only one child directly swap the values and chnage child node to null

case 3: key node have both the children the swap this key value either with 
        inorder predecessor or  inorder successor.
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
    
    public static int minValue(TreeNode tn) {
        if(tn.left !=null) return minValue(tn.left);
        else return tn.val;
    }
    
    public TreeNode remove(TreeNode root, int key) {
        if(root == null) return null;
        else if(root.val > key) root.left = remove(root.left, key);
        else if(root.val < key) root.right = remove(root.right, key);
        else if(root.left == null && root.right == null) return null;  // case 1
        else if(root.left != null && root.right != null) {
            int inorderSuccessor = minValue(root.right);
            root.val = inorderSuccessor;
            root.right = remove(root.right, inorderSuccessor);
            return root;
        }
        else if(root.left != null) return root.left;
        else if(root.right != null) return root.right;
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        return remove(root, key);
        //return root;
    }
}

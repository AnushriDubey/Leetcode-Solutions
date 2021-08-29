/*

Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Example 1:

Input:
        1
      /   \
     2     3    
   
Output: 1 2 3
Explanation:


Example 2:

Input:
          20
        /   \
       8     22
     /   \    \
    4    12    25
        /  \ 
       10   14 

Output: 20 8 4 10 14 25 22
Explanation: 
 

Your Task:
This is a function problem. You don't have to take input. Just complete the function printBoundary() that takes the root node as input and returns an array containing the boundary values in anti-clockwise.

 

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(Height of the Tree).

 

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 105



*/


class Solution
{
    static ArrayList<Integer> al;
    public static void printLeft(Node root) {
        if(root == null) return ;
        
        if(root.left != null) {
            al.add(root.data);
            printLeft(root.left);
        }
        else if(root.right != null) {
            al.add(root.data);
            printLeft(root.right);
        }
    }

    public static void printRight(Node root) {
        if(root == null) return ;
        
        if(root.right != null) {
            printRight(root.right);
            al.add(root.data);
        }
        else if(root.left != null) {
            printRight(root.left);
            al.add(root.data);
        }
    }

    public static void printLeaves(Node root) {
        if (root == null) return;
        if(root.left == null && root.right == null) al.add(root.data);
        printLeaves(root.left);
        printLeaves(root.right);
    }
    
	ArrayList <Integer> printBoundary(Node node)
	{
	    al = new ArrayList<>();
	    if(node == null) return al;
	    al.add(node.data);
	    printLeft(node.left);
	    printLeaves(node.left);
	    printLeaves(node.right);
	    printRight(node.right);
	    return al;
	}
}
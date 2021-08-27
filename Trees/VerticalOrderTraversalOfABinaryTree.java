/*

https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000


Description: 
1. using levels to sort within same horizontal distance. If level same the go for values if values same keep in the same order they are comming.
nodes at the same horizontal distance is at the same vertical line. keep all the node of same horizontal distance in the order of pt. 1


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
    
    static Map<TreeNode, Integer> mp;
    static TreeMap<Integer, TreeSet<TreeNode>> res;
    static Comparator<TreeNode> c = new Comparator<TreeNode>(){
        public int compare(TreeNode t1, TreeNode t2) {
            if(mp.get(t1)-mp.get(t2)==0) {
                if(t1.val - t2.val == 0) return 1;
                return t1.val - t2.val;
            }
            return mp.get(t1)-mp.get(t2);
        } 
    }; 
    
    public static void levelCalc(TreeNode root, int level) {
        if(root == null) return ;
        mp.put(root, level);
        levelCalc(root.left, level+1);
        levelCalc(root.right, level+1);
    }
    
    public static void verticalOT(TreeNode root, int hd) {
        if(root == null) return ;
        TreeSet<TreeNode> ts = res.getOrDefault(hd, new TreeSet<>(c));
        ts.add(root);
        res.put(hd,ts);
        verticalOT(root.left, hd-1);
        verticalOT(root.right, hd+1);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        res = new TreeMap<>();
        mp = new HashMap<>();
        levelCalc(root,0);
        verticalOT(root, 0);
        for(Map.Entry<Integer, TreeSet<TreeNode>> e: res.entrySet()) {
            ArrayList<Integer> al = new ArrayList<>();
            for(TreeNode tn: e.getValue()) al.add(tn.val);
            ll.add(al);
        }
        return ll;
    }
}

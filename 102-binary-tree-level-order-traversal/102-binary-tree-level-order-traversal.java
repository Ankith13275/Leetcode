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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> OuterList = new LinkedList<List<Integer>>();
        if(root == null) return OuterList;
        queue.add(root);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> InnerList = new LinkedList<>();
            for(int i = 0; i < levelNum; i++){
                TreeNode node = queue.peek();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                InnerList.add(queue.poll().val);
            }
            OuterList.add(InnerList);
        }
        return OuterList;
    }
}
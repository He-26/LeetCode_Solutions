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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList();
        if(root==null)  return res;
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        int l=0;
        while(q.size()>0){
            int n=q.size();
            List<Integer> level=new ArrayList();
            Stack<Integer> stack=new Stack();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(l%2==0){
                    level.add(node.val);
                }else{
                    stack.add(node.val);
                }
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            l++;
            while(!stack.isEmpty()){
                level.add(stack.pop());
            }
            res.add(level);
        }
        return res;
    }
}

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
    Map<String,Integer> map;
    List<TreeNode> list;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map=new HashMap<>();
        list=new ArrayList<>();
        duplicate(root);
        return list;
    }
    public String duplicate(TreeNode root){
        if(root==null){
            return "X";
        }
        String l=duplicate(root.left);
        String r=duplicate(root.right);
        String s=Integer.toString(root.val)+"-"+l+"-"+r;
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2){
            list.add(root);
        }
        return s;
    }
}

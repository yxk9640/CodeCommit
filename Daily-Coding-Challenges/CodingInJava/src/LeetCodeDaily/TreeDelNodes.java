package LeetCodeDaily;/*
 @yxk
*/

import java.util.*;

import static LeetCodeDaily.BuildTree.buildTreeFromList;

public class TreeDelNodes {
    public static void main(String[] args) {
        Integer[] list ={1,2,3,4,5,6,7};
        TreeNode root = buildTreeFromList(list);

        List<TreeNode> finalTree = delNodes(root, new int[]{3,5});
    }
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();

        Set<Integer> target = new HashSet<>();
        for(int tar:to_delete) target.add(tar);

        root = dfs(root,res ,target);

        if (root!=null) res.add(root);

        for (TreeNode tree: res){
            System.out.println(tree.val);
        }

        return res;
    }
    public static TreeNode dfs(TreeNode node,List<TreeNode> res,
                               Set<Integer> target){
        if( node == null) return null;
        node.left = dfs(node.left, res, target);
        node.right = dfs(node.right, res,target);
        if (target.contains(node.val)) {
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
            return null;
        }
        return node;


    }
}

package LeetCodeDaily;/*
 @yxk
*/

import static LeetCodeDaily.BuildTree.buildTreeFromList;

public class TreeCountLeafPairs {
    public static void main(String[] args) {
        Integer[] list ={1,2,3,4,5,6,7};
        TreeNode root = buildTreeFromList(list);

        System.out.println(countPairs(root, 3));
    }
    public static int countPairs(TreeNode root, int distance) {

        return dfsLCA(root, distance)[11];
    }
    public static int[] dfsLCA(TreeNode node, int dist){
        if (node == null) return new int[12];
        // leaf node
        if (node.left == null && node.right==null) {
            int[] current = new int[12];
            current[0] = 1;
            return current;
        }
        int[] left = dfsLCA(node.left, dist);
        int[] right = dfsLCA(node.right,dist);

        int[] cur = new int[12];
        for (int i = 0; i < 10; i++) {
            cur[i+1] += left[i]+right[i];
        }
        cur[11]+=left[11]+right[11];

        for (int d1 = 0; d1 <= dist; d1++) {
            for (int d2 = 0; d2 <= dist; d2++) {
                if ( 2 + d1 + d2 <= dist)
                    cur[11]+= left[d1]*right[d2];
            }

        }

        return cur;
    }
}

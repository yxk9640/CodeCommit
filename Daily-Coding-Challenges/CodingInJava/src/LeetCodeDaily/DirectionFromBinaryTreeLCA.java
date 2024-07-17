/**
@yxk
 */
class Solution {
     public static String getDirections(TreeNode root, int startValue, int destValue) {
        String res = "";
        Stack<String> start_path = dfs(root, new Stack(), startValue);
        Stack<String> dest_path = dfs(root, new Stack(), destValue);
        System.out.println(start_path);
        int i = 0;
        while(i < start_path.size() && i < dest_path.size()){
            if ( start_path.get(i) != dest_path.get(i) )
                break;
            i++;
        }
        //start_path -> "U"
        for (int j = i; j < start_path.size(); j++) {
            res+="U";
        }
        //dest_path -> dest_path[i]
        for (int k = i; k < dest_path.size(); k++) {
            res+=dest_path.get(k);
        }

        return res;
    }

     public static Stack<String> dfs(TreeNode node, Stack path, int target){
        if (node == null){return new Stack<>();}

        if (node.val == target) return (Stack<String>) path.clone();
        //when we go left
        path.push("L");
        Stack<String> ans = dfs(node.left, path, target);
        if (!ans.isEmpty()) return ans;
        //if node.val is not in left go right and should pop the path
        path.pop();
        path.add("R");
        Stack ans2 = dfs(node.right, path, target);
        if (!ans2.isEmpty()) return ans2;
        
        path.pop();

        return new Stack();
    }
}

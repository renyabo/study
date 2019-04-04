package org.yabo.utils.poi;

import java.util.*;

public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> levels = new HashMap<>();
        dfs(levels, root, 1);
        Set<Integer> keySet = levels.keySet();
        for (Integer key : keySet) {
            List<Integer> list = levels.get(key);
            result.addFirst(list);
        }
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> levels, TreeNode root, int level) {
        List<Integer> list = levels.getOrDefault(level, new ArrayList<Integer>());
        list.add(root.val);
        levels.put(level, list);
        if (root.left != null) {
            dfs(levels, root.left, level + 1);
        }
        if (root.right != null) {
            dfs(levels, root.right, level + 1);
        }
    }


}

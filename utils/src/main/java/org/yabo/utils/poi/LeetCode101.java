package org.yabo.utils.poi;

import java.util.*;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            if (levelSymmetric(level)) {
                List<TreeNode> next = new ArrayList<>();
                for (TreeNode treeNode : level) {
                    if (treeNode.left != null) {
                        next.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        next.add(treeNode.right);
                    }
                }
                level.clear();
                level = next;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean levelSymmetric(List<TreeNode> level) {
        if (level.isEmpty()) {
            return true;
        }
        int i = 0, j = level.size() - 1;
        while (i <= j) {
            if (level.get(i++) != level.get(j--)) {
                return false;
            }
        }
        return true;
    }


}

package org.yabo.utils.poi;

import java.util.*;

public class LeetCode100 {
    boolean same = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!same) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (p.val != q.val) {
                same = false;
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            same = false;
            return false;
        }
    }


}

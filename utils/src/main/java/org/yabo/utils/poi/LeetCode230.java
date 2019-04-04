package org.yabo.utils.poi;

import java.util.Stack;

public class LeetCode230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<>();
        dfs(stack, root, k);
        return stack.pop();
    }

    private void dfs(Stack<Integer> stack, TreeNode root, int k) {
        if (stack.size() == k) {
            return;
        }
        if (root.left != null) {
            dfs(stack, root.left, k);
        }
        stack.push(root.val);
        if (root.right != null) {
            dfs(stack, root.right, k);
        }
    }
}

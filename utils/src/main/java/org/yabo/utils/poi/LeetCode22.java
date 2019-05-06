package org.yabo.utils.poi;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        char[] seq = new char[n * 2];
        List<String> res = new ArrayList<>();
        if (n > 0) {
            dfs(res, seq, 0, 0, 0, n);
        }
        return res;
    }

    private void dfs(List<String> res, char[] seq, int index, int leftCount, int rightCount, int n) {
        if (leftCount < rightCount) {
            return;
        }
        if (index == seq.length) {
            res.add(new String(seq));
            return;
        }
        if (leftCount<n) {
            seq[index] = '(';
            dfs(res, seq, index + 1, leftCount + 1, rightCount, n);
        }
        if (rightCount<n) {
            seq[index] = ')';
            dfs(res, seq, index + 1, leftCount, rightCount + 1, n);
        }
    }
}

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
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

public class MainClass {
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            List<String> ret = new Solution().generateParenthesis(n);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}
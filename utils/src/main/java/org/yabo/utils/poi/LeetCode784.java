package org.yabo.utils.poi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        res.add(S);
        if (S.length() > 1) {
            dfs(res, S.toCharArray(), 0);
        }
        return res;
    }

    private void dfs(List<String> res, char[] chars, int index) {
        for (int i = index; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                chars[i] = (char) (chars[i] - 'a' + 'A');
                res.add(new String(chars));
                dfs(res, chars, index + 1);
                chars[i] = c;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(String.format("a=%s",null));
    }

}


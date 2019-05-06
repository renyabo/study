package org.yabo.utils.poi;

import java.util.*;

public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!index.containsKey(s.charAt(i))) {
                index.put(s.charAt(i), new ArrayList<>());
            }
            index.get(s.charAt(i)).add(i + 1);
        }
        int maxLength = 0;
        for (List<Integer> list : index.values()) {
            Collections.sort(list);
            if (list.size() == 1) {
                int max = Math.max(list.get(0) + 1, s.length() - list.get(0) + 1);
                maxLength = Math.max(max, maxLength);
            } else {
                maxLength = Math.max(list.get(0) + 1, maxLength);
                maxLength = Math.max(s.length() - list.get(list.size() - 1) + 1, maxLength);
                for (int i = 1; i < list.size(); i++) {
                    maxLength = Math.max(maxLength, list.get(i) - list.get(i - 1) + 1);
                }
            }
        }
        return maxLength;
    }
}

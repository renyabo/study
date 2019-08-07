package org.yabo.utils.poi;

import java.util.HashMap;
import java.util.Map;

public class LeetCode14 {

    static class Node {
        Map<Character, Node> children = new HashMap<>();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int maxLength = Integer.MAX_VALUE;
        Map<Character, Node> map = new HashMap<>();
        for (String str : strs) {
            if (str == null || str.length() == 0) {
                return "";
            }
            maxLength = Math.min(maxLength, str.length());
            char c = str.charAt(0);
            if (!map.containsKey(c)) {
                map.put(c, new Node());
            }
            Node node = map.get(c);
            for (int i = 1; i < str.length(); i++) {
                c = str.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Node());
                }
                node = node.children.get(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int length = 0;
        while (length < maxLength && map != null && map.keySet().size() == 1) {
            Character key = null;
            for (Character character : map.keySet()) {
                key = character;
            }
            sb.append(key);
            map = map.get(key).children;
            length++;
        }
        return sb.length() == 0 ? "" : sb.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            if (str == null || str.length() == 0) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                builder.append(str);
                String key = builder.toString();
                Integer orDefault = map.getOrDefault(key, 0);
                map.put(key, orDefault + 1);
            }
        }
        Map.Entry<String, Integer> max = null;
        Integer maxKeyLength = 0, maxValueCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxKeyLength < entry.getKey().length() && maxValueCount < entry.getValue()) {
                maxKeyLength = entry.getKey().length();
                maxValueCount = entry.getValue();
                max = entry;
            }
        }
        return max != null ? max.getKey() : "";
    }
}
